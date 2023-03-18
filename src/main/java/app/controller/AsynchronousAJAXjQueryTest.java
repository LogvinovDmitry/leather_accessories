package app.controller;

import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/asynchronous-AJAX-jQuery-Test"})
@MultipartConfig
public class AsynchronousAJAXjQueryTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserServiceImpl();
        List<BagDto> fullListOfProducts = userService.getAll();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String strJsonFullListOfProducts = new Gson().toJson(fullListOfProducts);//Почти любой объект переводит в строку
        resp.getWriter().write(strJsonFullListOfProducts);

    }

}




