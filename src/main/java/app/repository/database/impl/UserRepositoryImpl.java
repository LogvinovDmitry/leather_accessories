package app.repository.database.impl;

import app.model.Bag;
import app.repository.BagParam;
import app.repository.ConnectionLeatherAccessoriesSchema;
import app.repository.database.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static final String GET_All = "SELECT i.bag_id, i.bag_name, i.bag_description, i.bag_date_added, i.bag_price, c.bag_category_inf FROM leather_accessories_schema.bag_information_1 i INNER JOIN leather_accessories_schema.bag_category c ON i.bag_category = c.category_id";

    ConnectionLeatherAccessoriesSchema conLeather = new ConnectionLeatherAccessoriesSchema();

    @Override
    public List<BagParam> getAll() {
        List<BagParam> bagInf = new ArrayList<>();

        Connection con = conLeather.getConnection();

        try (PreparedStatement preparedStatement_get_all = con.prepareStatement(GET_All);
            ResultSet resultSet = preparedStatement_get_all.executeQuery()) {

            while (resultSet.next()) {
                BagParam bagParam = new BagParam();
                bagParam.setBag_id(resultSet.getInt("i.bag_id"));
                bagParam.setBag_name(resultSet.getString("i.bag_name"));
                //bagParam.setBag_category(resultSet.getInt("bag_category"));
                bagParam.setBag_description(resultSet.getString("i.bag_description"));
                bagParam.setBag_date_added(resultSet.getString("i.bag_date_added"));
                bagParam.setBag_price(resultSet.getDouble("i.bag_price"));
                bagParam.setBag_category_inf(resultSet.getString("c.bag_category_inf"));

                bagInf.add(bagParam);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return bagInf;
    }
}
