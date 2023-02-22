package app.repository.impl;

import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.repository.AdminRepository;
import app.util.ConnectionLeatherAccessoriesSchema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    private static final String INSERT_NEW_BAG = "INSERT INTO leather_accessories_schema.bag_information VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    private static final String INSERT_NEW_BAG_PHOTO = "INSERT INTO leather_accessories_schema.bag_photo VALUES (NULL, ?, ?)";

    ConnectionLeatherAccessoriesSchema conLeather = new ConnectionLeatherAccessoriesSchema();


    @Override
    public void createBag(Bag bag) {

        Connection con = conLeather.getConnection();

        try (PreparedStatement preparedStatement = getCreateStatement(con, bag);
             ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

            if (resultSet.next()) {
                int generatedId = resultSet.getInt(1);
                bag.setBagId(generatedId);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to put bag in table 'bag_information'", e);
        }

    }

    private PreparedStatement getCreateStatement(Connection con, Bag bag) throws SQLException {

        PreparedStatement preparedStatement = con.prepareStatement(INSERT_NEW_BAG, PreparedStatement.RETURN_GENERATED_KEYS); //в запросе необходимо ставить флаг RETURN_GENERATED_KEYS что бы потом была возможность вернуть сгенерированые поля: ResultSet resultSet = preparedStatement.getGeneratedKeys()
        preparedStatement.setString(1, bag.getBagName());
        preparedStatement.setInt(2, bag.getBagCategory());
        preparedStatement.setString(3, bag.getBagDescription());
        preparedStatement.setObject(4, bag.getBagDateAdded());
        preparedStatement.setDouble(5, bag.getBagPrice());
        preparedStatement.setString(6, bag.getMainPhotoTitle());


        preparedStatement.executeUpdate();
        return preparedStatement;
    }


    @Override
    public void createBagPhoto(BagPhoto bagPhoto) {

        Connection con = conLeather.getConnection();

        try (PreparedStatement preparedStatement = getCreateStatementBagPhoto(con, bagPhoto);
             ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

            if (resultSet.next()) {
                int generatedId = resultSet.getInt(1);
                bagPhoto.setPhotoId(generatedId);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to put other bag photo in table 'bag_photo'", e);
        }


    }


    private PreparedStatement getCreateStatementBagPhoto(Connection con, BagPhoto bagPhoto) throws SQLException {

        PreparedStatement preparedStatement = con.prepareStatement(INSERT_NEW_BAG_PHOTO, PreparedStatement.RETURN_GENERATED_KEYS); //в запросе необходимо ставить флаг RETURN_GENERATED_KEYS что бы потом была возможность вернуть сгенерированые поля: ResultSet resultSet = preparedStatement.getGeneratedKeys()

        preparedStatement.setInt(1, bagPhoto.getBagId());
        preparedStatement.setString(2, bagPhoto.getPhotoTitle());

        preparedStatement.executeUpdate();
        return preparedStatement;
    }
}
