package com.hermes.application.states;

import com.hermes.domain.employees.AbstractDriver;
import com.hermes.domain.employees.AbstractEmployee;
import com.hermes.domain.users.RepresentedUser;
import com.hermes.application.ConsoleView;
import com.hermes.userinterface.Controller;

/**
 * Created by ivan on 31.10.16.
 */
public class DriverState extends AbstractRepresentedUserState {

    DriverState(RepresentedUser currentUser) {
        super(currentUser);
    }

    public void analyseCommands(Controller controller){

        ConsoleView consoleView = controller.getConsoleView();
        consoleView.print("Driver: ");
        String[] command = consoleView.readLine();

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()){
                    case "report":
                        consoleView.println("Reporting finished haul!");
                        return;
                    case "license":
                        printLicense(controller);
                        return;
                }
        }

        analyseCommandsRepresented(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  report: sends report that you have arrived to your current checkpoint");
        consoleView.println("  license: shows driver license of current user");
    }

    private void printLicense(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();

        AbstractEmployee employee = getCurrentUser().getRepresentation();
        if(!(employee instanceof AbstractDriver)){
            throw new IllegalStateException();
        }
        AbstractDriver driver = (AbstractDriver) employee;
        consoleView.println("This user can drive vehicles:");
        consoleView.println(driver.getDriverLicense().getAllVehicleTypes().toString());
    }
}
