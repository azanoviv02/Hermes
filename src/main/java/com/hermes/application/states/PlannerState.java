package com.hermes.application.states;

import com.hermes.application.ConsoleView;
import com.hermes.domain.users.AbstractUser;
import com.hermes.userinterface.Controller;

/**
 * Created by ivan on 31.10.16.
 */
public class PlannerState extends AbstractUserState {

    PlannerState(AbstractUser currentUser) {
        super(currentUser);
    }

    public void analyseCommands(Controller controller){

        ConsoleView consoleView = controller.getConsoleView();
        consoleView.print("Planner: ");
        String[] command = consoleView.readLine();

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()){
                    case "new":
                        consoleView.println("Creating haul!");
                        return;
                }
        }

        analyseCommandsUser(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  new: creates new haul");
    }
}
