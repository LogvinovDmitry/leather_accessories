package app.controller;

import app.controller.user.FullListOfProductsCommand;
import app.controller.user.ListOfMenBagsCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    private Map<String, Command> commandsMap = new HashMap<>();

    CommandHelper() {
        commandsMap.put("Full list of products", new FullListOfProductsCommand());
        commandsMap.put("List of men's bags", new ListOfMenBagsCommand());

    }


    Command chooseCommand(HttpServletRequest request) {

        final String commandSignature = request.getParameter("command");
//        if (!commandsMap.containsKey(commandSignature)) {
//            throw new UnsupportedCommandException(commandSignature);
//        }
        return commandsMap.get(commandSignature);
    }
}
