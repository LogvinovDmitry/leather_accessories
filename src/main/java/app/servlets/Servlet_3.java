//package app.servlets;
//
//import repository.DataBase.BagParameters;
////import repository.DataBase.ConnectionLeatherAccessoriesSchema;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(urlPatterns = {"/servlet_3"})
//public class Servlet_3 extends HttpServlet {
//
//    public static final String NAME_USER = "root";
//    public static final String PASSWORD = "345680qwer";
//    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
//
//    private static final String INSERT_NEW = "INSERT INTO my_movies.table_test VALUES (?, ?, ?)";
//    private static final String GET_All = "SELECT * FROM my_movies.movies";
//    private static final String DEL = "DELETE FROM my_movies.table_test WHERE test_id = ?";
//
//    @Override
//
//    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
//        httpServletResponse.setContentType("text/html;charset=UTF-8"); //Добавить русский язык (а вообще подсказать клиенту (браузеру) какой тип данный будет отослан в ответе
//        PrintWriter pr = httpServletResponse.getWriter();
//
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "345680qwer");
//             PreparedStatement preparedStatement1 = connection.prepareStatement(GET_All);
//             //Statement statement = connection.createStatement();
//        ) {
//
//            List<BagParameters> arr1 = new ArrayList<>();
//            ResultSet resultSet = preparedStatement1.executeQuery();
//
//            while (resultSet.next()) {
//                BagParameters movies = new BagParameters();
//                movies.setMovies_id(resultSet.getInt("movies_id"));
//                movies.setMovie_title(resultSet.getString("movie_title"));
//                movies.setGenre(resultSet.getString("genre"));
//                movies.setRating(resultSet.getInt("rating"));
//                movies.setProducer_id(resultSet.getInt("producer_id"));
//                arr1.add(movies);
//
//
//
//                //pr.println(movies);
//                //pr.println(resultSet.getString("movie_title"));
//            }
//            //pr.println(arr1.get(1).getMovie_title());
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        pr.println("<html>");
//        pr.println("<h1> Мапинг этого сервлета осуществлен через аннотацию" + "</h1> ");
//        pr.println("</html>");
//
//    }
//}
