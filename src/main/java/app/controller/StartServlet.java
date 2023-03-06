package app.controller;

import app.model.dto.BagDto;
import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.service.UserService;
import app.service.impl.UserServiсeImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


@WebServlet(urlPatterns = {"/start-servlet"})
@MultipartConfig
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserServiсeImpl();
        List<BagDto> fullListOfProducts = userService.getAll();


        List<BagDto> listForChangingPictures = new ArrayList<>();
        while (listForChangingPictures.size() < 5) {

            int a = (int) (Math.random() * fullListOfProducts.size());

            if (!listForChangingPictures.contains(fullListOfProducts.get(a))) {
                listForChangingPictures.add(fullListOfProducts.get(a));
            }

        }



        List<BagDto> listForYouInterested = new ArrayList<>();
        while (listForYouInterested.size() < 9) {

            int a = (int) (Math.random() * fullListOfProducts.size());

            if (!listForYouInterested.contains(fullListOfProducts.get(a))) {
                listForYouInterested.add(fullListOfProducts.get(a));
            }

        }


        req.setAttribute("listForChangingPictures", listForChangingPictures);
        req.setAttribute("listForYouInterested", listForYouInterested);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("indexGo.jsp");
        requestDispatcher.forward(req, resp);
    }

}




