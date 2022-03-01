package io.github.moehreag.krimiadvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class StartController {
    public RadioButton person1;
    public Button back;
    public RadioButton person2;
    public Button finish;
    @FXML
    private Label welcomeText;
    @FXML
    private Label stageText;

    @FXML
    private Button button;

    @FXML
    private Button tip;

    private final String[] stages = {
            "Der Mörder hat wieder zugeschlagen!",//Für jedes Datum hier den Text einfügen!
            "",
            "",
    };

    private final String mörder = "hihi";

    private final String entrance = "";

    @FXML
    protected void onStartButtonClick() {
        HelloApplication.stage++;
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM");
        String currentDate = format.format(date);
        String day = currentDate.split("/")[0];
        String month = currentDate.split("/")[1];

        /*//Für distribution einkommentieren!
        if(!month.contains("24")){
            welcomeText.setText("Es ist nicht Dezember!");
            return;
        }
        if (Integer.parseInt(day) > 24){
            welcomeText.setText("Es ist schon nach Weihnachten!");
            return;
        }*/


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
        VBox tipLayout = new VBox();
        tipLayout.setAlignment(Pos.CENTER);



        person1 = new RadioButton("Name");//Für jede Personalie einen Knopf machen & Namen eintragen!
        person2 = new RadioButton("hihi");

        ToggleGroup group = new ToggleGroup();

        person1.setToggleGroup(group);//Auch für jede Personalie machen!
        person2.setToggleGroup(group);

        group.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            if(Objects.equals(newVal.toString(), mörder))setWinScene();
            else setTryagainScene();
        });

        TilePane plane = new TilePane();
        plane.setAlignment(Pos.CENTER);

        plane.getChildren().add(person1);//Leider auch für alle Personen hinkopieren!
        plane.getChildren().add(person2);

        tipLayout.getChildren().add(plane);

        plane.setVgap(20);
        plane.setPrefRows(2);

        tipLayout.setPadding(new Insets(10, 10,10,10));

        back = new Button("Zurück");

        back.setOnAction(e -> {
            HelloApplication.FXstage.setScene(HelloApplication.scene);
        });
        plane.getChildren().add(back);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tip-view-fxml.fxml"));
        Scene tipScene = new Scene(fxmlLoader.load(), 320, 240);

        HelloApplication.FXstage.setScene(tipScene);

    }

    private void setWinScene(){
            System.out.println("Gewonnen!");
    }

    private void setTryagainScene(){
        System.out.println("Nochmal!");
    }
}