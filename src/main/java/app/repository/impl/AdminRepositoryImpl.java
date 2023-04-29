package app.repository.impl;

import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.model.entity.Client;
import app.model.entity.Order;
import app.repository.AdminRepository;
import app.util.ConnectionLeatherAccessoriesSchema;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    private static final String INSERT_NEW_BAG = "INSERT INTO leather_accessories_schema.bag_information VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    private static final String INSERT_NEW_BAG_PHOTO = "INSERT INTO leather_accessories_schema.bag_photo VALUES (NULL, ?, ?)";

    private static final String DEL_ENTRY_IN_BAG_PHOTO = "DELETE FROM `leather_accessories_schema`.`bag_photo` WHERE (`bag_id` = ?)";
    private static final String DEL_ENTRY_IN_BAG_INF = "DELETE FROM `leather_accessories_schema`.`bag_information` WHERE (`bag_id` = ?)";

    private static final String GET_ALL_CLIENTS = "SELECT client_id, client_name, client_phone, client_network, client_address, client_comment, client_number, client_date_added FROM leather_accessories_schema.client";
    private static final String GET_ORDER_FOR_CLIENTS = "SELECT order_id, order_bag_id, order_quantity, order_client_id FROM leather_accessories_schema.order WHERE order_client_id = ?";

    private static final String DEL_ORDER = "DELETE FROM `leather_accessories_schema`.`order` WHERE (`order_client_id` = ?)";
    private static final String DEL_CLIENT = "DELETE FROM `leather_accessories_schema`.`client` WHERE (`client_id` = ?)";


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

    @Override
    public void removeBag(int bagId) {
        Connection con = conLeather.getConnection();

        try {
// Рабочий вариант №1: (Однако по хорошему в БД надо было отметить в bagId каскадное удаление.. тогда запрос был бы один. Кстати такое вроде возможно сделать только в МайСкюл)
            PreparedStatement preparedStatement = con.prepareStatement(DEL_ENTRY_IN_BAG_PHOTO);
            preparedStatement.setInt(1, bagId);
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = con.prepareStatement(DEL_ENTRY_IN_BAG_INF);
            preparedStatement1.setInt(1, bagId);
            preparedStatement1.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Client> getListAllClients() {

        List<Client> listAllClients = new ArrayList<>();

        Connection con = conLeather.getConnection();

        try (PreparedStatement preparedStatement = con.prepareStatement(GET_ALL_CLIENTS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Client client = new Client();

                client.setClientId(resultSet.getInt("client_id"));
                client.setClientName(resultSet.getString("client_name"));
                client.setClientPhone(resultSet.getString("client_phone"));
                client.setClientNetwork(resultSet.getString("client_network"));
                client.setClientAddress(resultSet.getString("client_address"));
                client.setClientComment(resultSet.getString("client_comment"));
                client.setClientNumber(resultSet.getString("client_number"));

                LocalDateTime client_date_added = (LocalDateTime) resultSet.getObject("client_date_added");
                String dateStr = client_date_added.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                client.setClientDateAddedStr(dateStr);

                listAllClients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listAllClients;
    }

    @Override
    public List<Order> getListOrderForClient(int clientId) {
        List<Order> listOrderForClient = new ArrayList<>();

        Connection con = conLeather.getConnection();

        try (PreparedStatement preparedStatement = con.prepareStatement(GET_ORDER_FOR_CLIENTS)) {
             preparedStatement.setInt(1, clientId);
             ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();

                order.setOrderId(resultSet.getInt("order_id"));
                order.setOrderBagId(resultSet.getInt("order_bag_id"));
                order.setOrderQuantity(resultSet.getInt("order_quantity"));
                order.setOrderClientId(resultSet.getInt("order_client_id"));

                listOrderForClient.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOrderForClient;
    }


    @Override
    public void removeOrder(int clientId) {
        Connection con = conLeather.getConnection();

        try {
// Рабочий вариант №1: (Однако по хорошему в БД надо было отметить в bagId каскадное удаление.. тогда запрос был бы один. Кстати такое вроде возможно сделать только в МайСкюл)
            PreparedStatement preparedStatement = con.prepareStatement(DEL_ORDER);
            preparedStatement.setInt(1, clientId);
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = con.prepareStatement(DEL_CLIENT);
            preparedStatement1.setInt(1, clientId);
            preparedStatement1.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
