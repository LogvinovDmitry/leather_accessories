package app.controller.admin;

import app.controller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RedirectCommand implements Command {
    private final String newAddress;

    public RedirectCommand(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getNewAddress() {
        return newAddress;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

    }
}