package app.repository.impl;

import app.model.BagParam;
import app.repository.ConnectionLeatherAccessoriesSchema;
import app.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static final String GET_All = "SELECT i.bag_id, i.bag_name, i.bag_description, i.bag_date_added, i.bag_price, c.bag_category_inf FROM leather_accessories_schema.bag_information_1 i INNER JOIN leather_accessories_schema.bag_category c ON i.bag_category = c.category_id";
    private static final String GET_CATEGORY = "SELECT i.bag_id, i.bag_name, i.bag_description, i.bag_date_added, i.bag_price, c.bag_category_inf FROM leather_accessories_schema.bag_information_1 i INNER JOIN leather_accessories_schema.bag_category c ON i.bag_category = c.category_id WHERE bag_category_inf = ?";

    ConnectionLeatherAccessoriesSchema conLeather = new ConnectionLeatherAccessoriesSchema();


    private List<BagParam> formingAListByParameters(ResultSet resultSet) throws SQLException {
        List<BagParam> ListByParameters = new ArrayList<>();


        while (resultSet.next()) {
            BagParam bagParam = new BagParam();
            bagParam.setBagId(resultSet.getInt("i.bag_id"));
            bagParam.setBagName(resultSet.getString("i.bag_name"));
            bagParam.setBagDescription(resultSet.getString("i.bag_description"));
            bagParam.setBagDateAdded(resultSet.getString("i.bag_date_added"));
            bagParam.setBagPrice(resultSet.getDouble("i.bag_price"));
            bagParam.setBagCategoryInf(resultSet.getString("c.bag_category_inf"));

            ListByParameters.add(bagParam);
        }

        return ListByParameters;
    }

    @Override
    public List<BagParam> getAll() {

        List<BagParam> fullListOfProducts = new ArrayList<>();

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
    public List<BagParam> getListOfBagsByCategory(String category) {

        Connection con = conLeather.getConnection();
        List<BagParam> listOfBagsByCategory = new ArrayList<>();

        try (PreparedStatement preparedStatement = con.prepareStatement(GET_CATEGORY)) {
            preparedStatement.setString(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();
            listOfBagsByCategory = formingAListByParameters(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfBagsByCategory;

    }

}


//     Работающий метод
//    @Override
//    public List<BagParam> getListOfBagsByCategory() {
//        List<BagParam> bagInf = new ArrayList<>();
//
//        Connection con = conLeather.getConnection();
//
//        try (PreparedStatement preparedStatement_get_all = con.prepareStatement(GET_CATEGORY)) {
//            preparedStatement_get_all.setString(1, "Accessories");
//            preparedStatement_get_all.execute();
//            ResultSet resultSet = preparedStatement_get_all.executeQuery();
//            while (resultSet.next()) {
//                BagParam bagParam = new BagParam();
//                bagParam.setBag_id(resultSet.getInt("i.bag_id"));
//                bagParam.setBag_name(resultSet.getString("i.bag_name"));
//                //bagParam.setBag_category(resultSet.getInt("bag_category"));
//                bagParam.setBag_description(resultSet.getString("i.bag_description"));
//                bagParam.setBag_date_added(resultSet.getString("i.bag_date_added"));
//                bagParam.setBag_price(resultSet.getDouble("i.bag_price"));
//                bagParam.setBag_category_inf(resultSet.getString("c.bag_category_inf"));
//
//                bagInf.add(bagParam);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return bagInf;
//
//    }