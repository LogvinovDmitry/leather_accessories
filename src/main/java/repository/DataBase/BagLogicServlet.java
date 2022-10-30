package repository.DataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/bag-logic-servlet"})
public class BagLogicServlet extends HttpServlet {

    private static final String INSERT_NEW = "INSERT INTO my_movies.table_test VALUES (?, ?, ?)";
    private static final String GET_All = "SELECT * FROM leather_accessories_schema.bag_information_1";
    private static final String DEL = "DELETE FROM my_movies.table_test WHERE test_id = ?";

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        ConnectionLeatherAccessoriesSchema conLeather = new ConnectionLeatherAccessoriesSchema();

        List<BagParam> bagInformation = new ArrayList<>();

        try (PreparedStatement preparedStatement = conLeather.getConnection().prepareStatement(GET_All)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BagParam bagParam = new BagParam();
                bagParam.setBag_id(resultSet.getInt("bag_id"));
                bagParam.setBag_name(resultSet.getString("bag_name"));
                bagParam.setBag_category(resultSet.getInt("bag_category"));
                bagParam.setBag_description(resultSet.getString("bag_description"));

                bagInformation.add(bagParam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        httpServletRequest.setAttribute("bagInformation", bagInformation);

        //getServletContext().getRequestDispatcher("/bagInformationRender.jsp").forward(httpServletRequest, httpServletResponse);
        getServletContext().getRequestDispatcher("/bagInformationRenderTaglib.jsp").forward(httpServletRequest, httpServletResponse);

    }


}