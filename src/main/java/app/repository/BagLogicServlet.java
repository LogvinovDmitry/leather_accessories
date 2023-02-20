package app.repository;

import app.model.entity.Bag;
import org.apache.commons.io.IOUtils;
import app.util.ConnectionLeatherAccessoriesSchema;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = {"/bag-logic-servlet"})
@MultipartConfig()
public class BagLogicServlet extends HttpServlet {

    private static final String GET_All = "SELECT i.bag_id, i.bag_name, i.bag_description, i.bag_date_added, i.bag_price, c.bag_category_inf FROM leather_accessories_schema.bag_information_1 i INNER JOIN leather_accessories_schema.bag_category c ON i.bag_category = c.category_id";
    private static final String INSERT_NEW = "INSERT INTO leather_accessories_schema.bag_information_1 VALUES (NULL, ?, ?, ?, ?, ?)";
    private static final String DEL = "DELETE FROM leather_accessories_schema.bag_information_1 WHERE bag_id = ?";
    ConnectionLeatherAccessoriesSchema conLeather = new ConnectionLeatherAccessoriesSchema();


    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Connection con = conLeather.getConnection();

        List<Bag> bagInformation = new ArrayList<>();

        try (PreparedStatement preparedStatement_get_all = con.prepareStatement(GET_All)) {

            ResultSet resultSet = preparedStatement_get_all.executeQuery();

            while (resultSet.next()) {
                Bag bag = new Bag();
                bag.setBagId(resultSet.getInt("i.bag_id"));
                bag.setBagName(resultSet.getString("i.bag_name"));
                //bagParam.setBag_category(resultSet.getInt("bag_category"));
                bag.setBagDescription(resultSet.getString("i.bag_description"));
                //bag.setBagDateAdded(resultSet.getString("i.bag_date_added"));
                bag.setBagDateAdded(resultSet.getObject("i.bag_date_added", LocalDate.class));
                bag.setBagPrice(resultSet.getDouble("i.bag_price"));
                bag.setBagCategoryInf(resultSet.getString("c.bag_category_inf"));

                bagInformation.add(bag);
            }
           // preparedStatement_del.setInt(1, );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        httpServletRequest.setAttribute("bagInformation", bagInformation);

        getServletContext().getRequestDispatcher("/bagInformationRender.jsp").forward(httpServletRequest, httpServletResponse);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = conLeather.getConnection();
        try (PreparedStatement preparedStatement_insert_new = con.prepareStatement(INSERT_NEW)) {


            for (Part part : req.getParts()) {

                if (part.getName().equals("form_bag_name")) {
                    InputStream inputStream = part.getInputStream();
                    String form_bag_name = IOUtils.toString(inputStream, "UTF-8");//Деает из стрима строку
                    preparedStatement_insert_new.setString(1, form_bag_name);
                    // preparedStatement_insert_new.execute();
                    //req.setAttribute("sec", s);
                } else if (part.getName().equals("bag_category")) {
                    InputStream inputStream = part.getInputStream();
                    String str_bag_category = IOUtils.toString(inputStream, "UTF-8");//Деает из стрима строку
                    int bag_category = Integer.parseInt(str_bag_category);
                    preparedStatement_insert_new.setInt(2, bag_category);
                    // preparedStatement_insert_new.execute();
                } else if (part.getName().equals("bag_price")) {
                    InputStream inputStream = part.getInputStream();
                    String str_bag_price = IOUtils.toString(inputStream, "UTF-8");//Деает из стрима строку
                    double bag_price = Double.parseDouble(str_bag_price);
                    preparedStatement_insert_new.setDouble(5, bag_price);
                    // preparedStatement_insert_new.execute();
                } else if (part.getName().equals("bag_date_added")) {
                    InputStream inputStream = part.getInputStream();
                    String str_bag_date_added = IOUtils.toString(inputStream, "UTF-8");//Деает из стрима строку
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str_bag_date_added);
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    //Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str_bag_date_added);
                    preparedStatement_insert_new.setDate(4, sqlDate);
                    // preparedStatement_insert_new.execute();
                } else if (part.getName().equals("bag_description")) {
                    InputStream inputStream = part.getInputStream();
                    String bag_description = IOUtils.toString(inputStream, "UTF-8");//Деает из стрима строку
                    preparedStatement_insert_new.setString(3, bag_description);
                    // preparedStatement_insert_new.execute();
                } else if (part.getName().equals("file-name")) {
                    String str = UUID.randomUUID().toString();
                    String fileName = getSubmittedFileName(part);

                    try (InputStream inputStream = part.getInputStream();
                         OutputStream outputStream = new FileOutputStream("C:\\Users\\Дмитрий\\leather_accessories\\file\\" + str + fileName)) {
                        IOUtils.copy(inputStream, outputStream);
                    }
                }

            }
            preparedStatement_insert_new.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/renderForm.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        Connection con = conLeather.getConnection();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.destroy();
    }
}
//String parameter = req.getParameter("type");
//Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
//req.setAttribute("type", parameter);

//getServletContext().getRequestDispatcher("/bagInformationRender.jsp").forward(httpServletRequest, httpServletResponse);
//getServletContext().getRequestDispatcher("/renderForm.jsp").forward(req, resp);


//    }
//}