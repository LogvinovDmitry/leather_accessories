package app.controller;

import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = {"/start-servlet"})
@MultipartConfig
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object oldItems = req.getSession().getAttribute("items");
        if (oldItems == null) {
            int size = 0;
            req.getSession().setAttribute("size", size);
        } else if (oldItems instanceof List) {
            ArrayList<Integer> items = (ArrayList<Integer>) oldItems;
            int size = items.size();
            req.getSession().setAttribute("size", size);
        }


        UserService userService = new UserServiceImpl();
        List<BagDto> fullListOfProducts = userService.getAll();


        List<BagDto> listForChangingPictures = new ArrayList<>();
        while (listForChangingPictures.size() < 6) {

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

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }

}




