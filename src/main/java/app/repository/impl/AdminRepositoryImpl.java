package app.repository.impl;

import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.repository.AdminRepository;
import app.util.ConnectionLeatherAccessoriesSchema;

import javax.servlet.http.Part;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpl implements AdminRepository {

    private static final String INSERT_NEW = "INSERT INTO leather_accessories_schema.bag_information VALUES (NULL, ?, ?, ?, ?, ?, ?)";

    ConnectionLeatherAccessoriesSchema conLeather = new ConnectionLeatherAccessoriesSchema();


    @Override
    public void create(Bag bag) {

        Connection con = conLeather.getConnection();

        try (PreparedStatement preparedStatement = getCreateStatement(con, bag);
             ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

            if (resultSet.next()) {
                int generatedId = resultSet.getInt(1);
                bag.setBagId(generatedId);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't put director to 'director' table", e);
        }

    }

    private PreparedStatement getCreateStatement(Connection con, Bag bag) throws SQLException {

        PreparedStatement preparedStatement = con.prepareStatement(INSERT_NEW, PreparedStatement.RETURN_GENERATED_KEYS); //в запросе необходимо ставить флаг RETURN_GENERATED_KEYS что бы потом была возможность вернуть сгенерированые поля: ResultSet resultSet = preparedStatement.getGeneratedKeys()
        preparedStatement.setString(1, bag.getBagName());
        preparedStatement.setInt(2, bag.getBagCategory());
        preparedStatement.setString(3, bag.getBagDescription());
        preparedStatement.setObject(4, bag.getBagDateAdded());
        preparedStatement.setDouble(5, bag.getBagPrice());
        preparedStatement.setString(6, bag.getMainPhotoTitle());


        preparedStatement.executeUpdate();
        return preparedStatement;
    }
}
