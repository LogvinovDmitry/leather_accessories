package app.controller;

import app.controller.admin.CreateNewEntryCommand;
import app.controller.user.DisplayFileCommand;
import app.controller.user.FullListOfProductsCommand;
import app.controller.user.ListOfBagsByCategoryCommand;
import app.exceptions.UnsupportedCommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    private Map<String, Command> commandsMap = new HashMap<>();

    CommandHelper() {
        //User command
        commandsMap.put("all products", new FullListOfProductsCommand());

        commandsMap.put("for men", new ListOfBagsByCategoryCommand());
        commandsMap.put("for women", new ListOfBagsByCategoryCommand());
        commandsMap.put("accessories", new ListOfBagsByCategoryCommand());

        commandsMap.put("Display file", new DisplayFileCommand());


        //Admin command
        commandsMap.put("Create new entry", new CreateNewEntryCommand());

    }


    Command chooseCommand(HttpServletRequest request) {

        final String commandSignature = request.getParameter("command");
        if (!commandsMap.containsKey(commandSignature)) {
            throw new UnsupportedCommandException(commandSignature);
        }
        return commandsMap.get(commandSignature);
    }
}
