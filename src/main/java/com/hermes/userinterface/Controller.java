package com.hermes.userinterface;

import com.hermes.application.ConsoleView;
import com.hermes.application.states.AbstractState;
import com.hermes.application.states.StartState;

public class Controller {

    private ConsoleView consoleView;
    private AbstractState state;

    public Controller() {
        this.consoleView = new ConsoleView(System.in, System.out);
        this.state = StartState.getInstance();
    }

    public ConsoleView getConsoleView() {
        return consoleView;
    }

    public AbstractState getState() {
        return state;
    }

    public void setState(AbstractState state) {
        this.state = state;
    }

    public void parseCommand() {
        this.state.analyseCommands(this);
    }

    public static void main(String[] args) {
        Controller cntr = new Controller();
        while (true) {
            cntr.parseCommand();
        }
    }
}
