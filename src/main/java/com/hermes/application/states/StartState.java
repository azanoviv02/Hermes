package com.hermes.application.states;

import com.hermes.domain.users.InvalidPasswordException;
import com.hermes.application.ConsoleView;
import com.hermes.userinterface.Controller;

/**
 * Created by ivan on 31.10.16.
 */
public class StartState extends AbstractState {

    private StartState() {
    }

    private static StartState instance = new StartState();

    public static StartState getInstance() {
        return instance;
    }

    public void analyseCommands(Controller controller) {

        ConsoleView consoleView = controller.getConsoleView();
        consoleView.print("Guest: ");
        String[] command = consoleView.readLine();

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()){
                    case "enter":
                        enterNewState(controller);
                        return;
                }
        }

        analyseCommandsGlobal(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  enter: enters into your personal account");
    }

    private void enterNewState(Controller controller) {

        ConsoleView consoleView = controller.getConsoleView();

        consoleView.print("Login: ");
        String login = consoleView.readLogin();
        consoleView.print("Password: ");
        String password = consoleView.readPassword();

        try{
            AbstractUserState newState = UserStateFactory.createUserState(login, password);
            controller.setState(newState);
        }catch(InvalidPasswordException e){
            consoleView.println("Error: incorrect password");
        }catch (NoSuchLoginException e){
            consoleView.println("Error: incorrect login");
        }
    }
}
