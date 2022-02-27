package io.github.moehreag.krimiadvent;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label stageText;

    @FXML
    private Button button;

    @FXML
    private Button tip;

    private final String[] stages = {
            "Der Mörder hat wieder zugeschlagen!",
            "",
            "",
    };

    private final String entrance = "";

    @FXML
    protected void onStartButtonClick() {
        HelloApplication.stage++;

        if (HelloApplication.stage >= 1) {
            tip.setVisible(true);
            welcomeText.setText(HelloApplication.stage + ". Akt");
            stageText.setText(stages[HelloApplication.stage-1]);
        }
        else {
            welcomeText.setText("Einführung");
            button.setText("Weiter");
            stageText.setText(entrance);
        }
    }

    @FXML
    protected void onTipButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        VBox tipLayout = new VBox();
        tipLayout.setAlignment(Pos.CENTER);

        Button back = new Button("Back");
        back.setOnAction(e -> HelloApplication.FXstage.setScene(scene));
        tipLayout.getChildren().add(back);
        Scene tipScene = new Scene(tipLayout, 320, 240);

        HelloApplication.FXstage.setScene(tipScene);
    }
}