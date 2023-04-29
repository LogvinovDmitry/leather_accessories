package app.repository.impl;

import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.model.entity.Client;
import app.model.entity.Order;
import app.util.ConnectionLeatherAccessoriesSchema;
import app.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    //private static final String GET_All = "SELECT i.bag_id, i.bag_name, i.bag_description, i.bag_date_added, i.bag_price, c.bag_category_inf FROM leather_accessories_schema.bag_information_1 i INNER JOIN leather_accessories_schema.bag_category c ON i.bag_category = c.category_id";
    private static final String GET_All = "SELECT i.bag_id, i.bag_name, i.bag_description, i.bag_date_added, i.bag_price, i.main_photo_title, c.bag_category_inf FROM leather_accessories_schema.bag_information i INNER JOIN leather_accessories_schema.bag_category c ON i.bag_category = c.category_id";
    private static final String GET_BAG = "SELECT i.bag_id, i.bag_name, i.bag_description, i.bag_date_added, i.bag_price, i.main_photo_title, c.bag_category_inf FROM leather_accessories_schema.bag_information i INNER JOIN leather_accessories_schema.bag_category c ON i.bag_category = c.category_id WHERE i.bag_id = ?";
    private static final String GET_CATEGORY = "SELECT i.bag_id, i.bag_name, i.bag_description, i.bag_date_added, i.bag_price, i.main_photo_title, c.bag_category_inf FROM leather_accessories_schema.bag_information i INNER JOIN leather_accessories_schema.bag_category c ON i.bag_category = c.category_id WHERE bag_category_inf = ?";
    //private static final String GET_PHOTO = "SELECT photo_title FROM leather_accessories_schema.bag_photo WHERE bag_id = ?";
    //private static final String GET_PHOTO = "SELECT photo_id, bag_id, photo_title FROM leather_accessories_schema.bag_photo";
    private static final String GET_PHOTO = "SELECT photo_id, bag_id, photo_title FROM leather_accessories_schema.bag_photo WHERE bag_id = ?";

    private static final String INSERT_NEW_CLIENT = "INSERT INTO leather_accessories_schema.client VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
    private static final String INSERT_NEW_ORDER = "INSERT INTO leather_accessories_schema.order VALUES (NULL, ?, ?, ?)";


    ConnectionLeatherAccessoriesSchema conLeather = new ConnectionLeatherAccessoriesSchema();


    private List<Bag> formingAListByParameters(ResultSet resultSet) throws SQLException {
        List<Bag> listByParameters = new ArrayList<>();


        while (resultSet.next()) {
            Bag bag = new Bag();
            bag.setBagId(resultSet.getInt("i.bag_id"));
            bag.setBagName(resultSet.getString("i.bag_name"));
            bag.setBagDescription(resultSet.getString("i.bag_description"));
            //director.setDayOfBirth(resultSet.getObject("day_of_birth", LocalDate.class));
            //bag.setBagDateAdded(resultSet.getString("i.bag_date_added"));
            bag.setBagDateAdded(resultSet.getObject("i.bag_date_added", LocalDate.class));
            bag.setBagPrice(resultSet.getDouble("i.bag_price"));
            bag.setBagCategoryInf(resultSet.getString("c.bag_category_inf"));
            bag.setMainPhotoTitle(resultSet.getString("i.main_photo_title"));

            listByParameters.add(bag);
        }

        return listByParameters;
    }

    @Override
    public List<Bag> getAll() {

        List<Bag> fullListOfProducts = new ArrayList<>();

        Connection con = conLeather.getConnection();

        try (PreparedStatement preparedStatement = con.prepareStatement(GET_All);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            fullListOfProducts = formingAListByParameters(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fullListOfProducts;
    }

    @Override
    public List<Bag> getListOfBagsByCategory(String category) {

        Connection con = conLeather.getConnection();
        List<Bag> listOfBagsByCategory = new ArrayList<>();

        try (PreparedStatement preparedStatement = con.prepareStatement(GET_CATEGORY)) {
            preparedStatement.setString(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();
            listOfBagsByCategory = formingAListByParameters(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfBagsByCategory;

    }

    @Override
    public List<BagPhoto> getListBagPhoto(int bagId) {
        List<BagPhoto> listBagPhoto = new ArrayList<>();

        Connection con = conLeather.getConnection();

        try (PreparedStatement preparedStatement = con.prepareStatement(GET_PHOTO)) {
            preparedStatement.setInt(1, bagId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BagPhoto bagPhoto = new BagPhoto();

                bagPhoto.setPhotoId(resultSet.getInt("photo_id"));
                bagPhoto.setBagId(resultSet.getInt("bag_id"));
                bagPhoto.setPhotoTitle(resultSet.getString("photo_title"));

                listBagPhoto.add(bagPhoto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBagPhoto;
    }

    @Override
    public Bag getBagById(int bagId) {
        Connection con = conLeather.getConnection();
        Bag bag = new Bag();
        //List<Bag> listOfBagsByCategory = new ArrayList<>();

        try (PreparedStatement preparedStatement = con.prepareStatement(GET_BAG)) {
            preparedStatement.setInt(1, bagId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                bag.setBagId(resultSet.getInt("i.bag_id"));
                bag.setBagName(resultSet.getString("i.bag_name"));
                bag.setBagDescription(resultSet.getString("i.bag_description"));
                //director.setDayOfBirth(resultSet.getObject("day_of_birth", LocalDate.class));
                //bag.setBagDateAdded(resultSet.getString("i.bag_date_added"));
                bag.setBagDateAdded(resultSet.getObject("i.bag_date_added", LocalDate.class));
                bag.setBagPrice(resultSet.getDouble("i.bag_price"));
                bag.setBagCategoryInf(resultSet.getString("c.bag_category_inf"));
                bag.setMainPhotoTitle(resultSet.getString("i.main_photo_title"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bag;
    }

    @Override
    public void createNewClient(Client client) {
        Connection con = conLeather.getConnection();

        try (PreparedStatement preparedStatement = getCreateStatementForClient(con, client);
             ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

            if (resultSet.next()) {
                int generatedId = resultSet.getInt(1);
                client.setClientId(generatedId);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to put new client in table 'Client'", e);
        }
    }

    private PreparedStatement getCreateStatementForClient(Connection con, Client client) throws SQLException {

        PreparedStatement preparedStatement = con.prepareStatement(INSERT_NEW_CLIENT, PreparedStatement.RETURN_GENERATED_KEYS); //в запросе необходимо ставить флаг RETURN_GENERATED_KEYS что бы потом была возможность вернуть сгенерированые поля: ResultSet resultSet = preparedStatement.getGeneratedKeys()

        preparedStatement.setString(1, client.getClientName());
        preparedStatement.setString(2, client.getClientPhone());
        preparedStatement.setString(3, client.getClientNetwork());
        preparedStatement.setString(4, client.getClientAddress());
        preparedStatement.setString(5, client.getClientComment());
        preparedStatement.setString(6, client.getClientNumber());
        preparedStatement.setObject(7, client.getClientDateAdded1());

        preparedStatement.executeUpdate();
        return preparedStatement;
    }

    @Override
    public void createNewOrder(Order order) {
        Connection con = conLeather.getConnection();

        try (PreparedStatement preparedStatement = getCreateStatementForOrder(con, order);
             ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

            if (resultSet.next()) {
                int generatedId = resultSet.getInt(1);
                order.setOrderId(generatedId);
                //client.setClientId(generatedId);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to put new order in table 'Order'", e);
        }
    }

    private PreparedStatement getCreateStatementForOrder(Connection con, Order order) throws SQLException {

        PreparedStatement preparedStatement = con.prepareStatement(INSERT_NEW_ORDER, PreparedStatement.RETURN_GENERATED_KEYS); //в запросе необходимо ставить флаг RETURN_GENERATED_KEYS что бы потом была возможность вернуть сгенерированые поля: ResultSet resultSet = preparedStatement.getGeneratedKeys()

        preparedStatement.setInt(1, order.getOrderBagId());
        preparedStatement.setInt(2, order.getOrderQuantity());
        preparedStatement.setInt(3, order.getOrderClientId());

        preparedStatement.executeUpdate();
        return preparedStatement;
    }

}
