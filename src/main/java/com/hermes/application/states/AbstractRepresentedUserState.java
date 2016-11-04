package com.hermes.application.states;

import com.hermes.application.ConsoleView;
import com.hermes.domain.users.AbstractUser;
import com.hermes.domain.users.RepresentedUser;
import com.hermes.userinterface.Controller;

/**
 * Created by ivan on 02.11.16.
 */
public abstract class AbstractRepresentedUserState extends AbstractUserState {
    public AbstractRepresentedUserState(RepresentedUser currentUser) {
        super(currentUser);
    }

    RepresentedUser getCurrentUser() {
        AbstractUser currentUser = super.getCurrentUser();
        if(currentUser instanceof RepresentedUser){
            return (RepresentedUser) currentUser;
        }else{
            throw new IllegalStateException();
        }
    }

    final void analyseCommandsRepresented(Controller controller, String[] command){

        ConsoleView consoleView = controller.getConsoleView();

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()) {
                    case "salary":
                        printSalary(controller);
                        return;
                }
        }

        analyseCommandsUser(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  salary: prints salary of current user;");
    }

    void printSalary(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();
        int amount = getCurrentUser().getRepresentation().getSalary();
        consoleView.println("Salary = "+amount);
    }
}
