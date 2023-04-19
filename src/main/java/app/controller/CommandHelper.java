package app.controller;

import app.controller.admin.*;
import app.controller.user.*;
import app.exceptions.UnsupportedCommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommandHelper {
    private Map<String, Command> commandsMap = new LinkedHashMap<>();

    CommandHelper() {
        //User command
        commandsMap.put("all products", new FullListOfProductsCommand());

        commandsMap.put("for men", new ListOfBagsByCategoryCommand());
        commandsMap.put("for women", new ListOfBagsByCategoryCommand());
        commandsMap.put("accessories", new ListOfBagsByCategoryCommand());

        commandsMap.put("Display file", new DisplayFileCommand());

        commandsMap.put("Bag by id", new BagByIdCommand());
        commandsMap.put("Add to Cart", new AddToCartCommand());
        commandsMap.put("Delete entry from cart", new DeleteEntryFromCartCommand());
        commandsMap.put("Buy now", new BuyNowCommand());
        commandsMap.put("Change quantity", new ChangeQuantityGoodsCommand());
        commandsMap.put("Basket", new BasketCommand());
        commandsMap.put("Create new order", new CreateNewOrderCommand());


        //Admin command
        commandsMap.put("Create new entry", new CreateNewEntryCommand());
        commandsMap.put("Remove entry", new RemoveEntryCommand());
        commandsMap.put("Exit admin", new ExitAdminCommand());
        commandsMap.put("Order page", new OrderPageCommand());
        commandsMap.put("Orders", new OrderPageAdminCommand());
        commandsMap.put("Enter", new RedirectCommand("/start-servlet"));

    }


    Command chooseCommand(HttpServletRequest request) {

        final String commandSignature = request.getParameter("command");
        if (!commandsMap.containsKey(commandSignature)) {
            throw new UnsupportedCommandException(commandSignature);
        }
        return commandsMap.get(commandSignature);
    }
}
