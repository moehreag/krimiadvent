package io.github.moehreag.krimiadvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StartController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label stageText;

    @FXML
    private Button button;

    @FXML
    protected void onStartButtonClick() {
        HelloApplication.stage++;
        switch (HelloApplication.stage){
            case 1:
                welcomeText.setText("1.Akt");
                button.setText("Weiter");


                break;
            case 2:
                welcomeText.setText("2.Akt");
                stageText.setText("Der Mörder hat wieder zugeschlagen!");
                break;
        }
        //welcomeText.setText("Welcome to JavaFX Application!");
    }
}