package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiсeImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BagByIdCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int bagId = Integer.parseInt(request.getParameter("bagId"));
        UserService userService = new UserServiсeImpl();
        BagDto bagDto = userService.getBagById(bagId);

        request.setAttribute("bagDto", bagDto);
        request.setAttribute("jsp", "bagById.jsp");
    }
}
