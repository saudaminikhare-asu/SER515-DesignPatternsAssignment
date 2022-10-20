package edu.asu.ptbs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PTBSApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Facade ptbsFacade = new Facade();
        ptbsFacade.login(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}