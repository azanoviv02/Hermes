package com.hermes.application.states;

import com.hermes.application.ConsoleView;
import com.hermes.domain.users.AbstractUser;
import com.hermes.userinterface.Controller;

/**
 * Created by ivan on 31.10.16.
 */
public abstract class AbstractUserState extends AbstractState {

    private AbstractUser currentUser;

    AbstractUserState(AbstractUser currentUser) {
        this.currentUser = currentUser;
    }

    AbstractUser getCurrentUser() {
        return currentUser;
    }

    //Template method pattern
    final void analyseCommandsUser(Controller controller, String[] command){

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()){
                    case "info":
                        printInfo(controller);
                        return;
                    case "exit":
                        exitCurrentState(controller);
                        return;
                }
        }

        analyseCommandsGlobal(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  info: prints information about current account;");
        consoleView.println("  exit: exits current account;");
    }

    void printInfo(Controller controller){
        controller.getConsoleView().println(currentUser.getName());
    }

    void exitCurrentState(Controller controller){
        controller.setState(StartState.getInstance());
    }

    boolean isAbort(String line){
        return line.toLowerCase().equals("abort");
    }

    boolean isValidName(String name){
        return ((name != null) && (name.length() > 0));
    }
}
