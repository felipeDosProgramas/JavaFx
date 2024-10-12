package com.ale.alessandro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartApp extends Application {
    private final VBox container = new VBox();
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(container, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}