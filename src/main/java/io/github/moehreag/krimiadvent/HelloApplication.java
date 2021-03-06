package io.github.moehreag.krimiadvent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static int stage = -1;
    public static Stage FXstage;
    public FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    public static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXstage = stage;
        scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Krimiadvent");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}