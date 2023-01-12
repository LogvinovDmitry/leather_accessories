package app.repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/del-servlet"})
@MultipartConfig()
public class DelServlet extends HttpServlet {

    private static final String DEL = "DELETE FROM leather_accessories_schema.bag_information_1 WHERE bag_id = ?";
    ConnectionLeatherAccessoriesSchema conLeather = new ConnectionLeatherAccessoriesSchema();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = conLeather.getConnection();
        try (PreparedStatement preparedStatement_del = con.prepareStatement(DEL)) {

            for (Part part : req.getParts()) {
               String str1 = part.getName();

                preparedStatement_del.setInt(1, Integer.parseInt(part.getName()));
            }

            preparedStatement_del.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

            getServletContext().getRequestDispatcher("/renderForm.jsp").forward(req, resp);


    }
}
