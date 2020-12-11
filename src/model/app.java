package model;

import controller.CarController;
import view.*;

public class app {

    public static void main(String[] args) throws InterruptedException {

        final int X = 800;
        final int Y = 800;

        Logic game = new Logic();

        CarController controller = new CarController(game);

        //create views and controllers
        MainView mainView = new MainView("Test", X, Y);
        GameView gameView = new GameView(X, Y - 240);
        ControlsView controlsView = new ControlsView(X, Y, controller);
        FactoryView factoryView = new FactoryView(800, 800, controller);

        //adds views to main window
        mainView.add(controlsView);
        mainView.add(factoryView);
        mainView.add(gameView);
        game.addObserver(gameView);


        while (true) {
            game.update();
            Thread.sleep(50);
        }
    }
}
