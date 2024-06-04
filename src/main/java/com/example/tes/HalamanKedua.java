package com.example.tes;

import com.example.tes.HelloApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HalamanKedua extends HelloApplication{

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(358, 340);

        Distant light = new Distant();
        light.setColor(new Color(0.8736842274665833, 0.6245223879814148, 0.7906302809715271, 1));
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        Shadow shadow = new Shadow();
        lighting.setBumpInput(shadow);
        GaussianBlur gaussianBlur = new GaussianBlur();
        gaussianBlur.setInput(lighting);

        Button kembaliButton = new Button("Kembali");
        kembaliButton.setLayoutX(147.0);
        kembaliButton.setLayoutY(170.0);
        kembaliButton.setPrefSize(78.0, 30.0);
        kembaliButton.setTextFill(Color.web("#630041"));
        kembaliButton.setFont(Font.font("OCR A Extended", 14));
        kembaliButton.setOnAction(actionEvent -> {
            HelloApplication menuUtama = new HelloApplication();
            menuUtama.start(primaryStage);
        });

        Blend blend = new Blend();
        ColorInput colorInput = new ColorInput();
        colorInput.setPaint(new Color(0.843, 0.776, 0.776, 1));
        blend.setTopInput(colorInput);
        kembaliButton.setEffect(blend);

        Text welcomeText = new Text("Hai, Kamu Berhasil Login");
        welcomeText.setFill(Color.web("#81004f"));
        welcomeText.setFont(Font.font("Berlin Sans FB", 27));
        welcomeText.setWrappingWidth(284.22509765625);

        VBox textBox = new VBox(welcomeText);
        textBox.setLayoutX(41.0);
        textBox.setLayoutY(127.0);
        textBox.setPrefSize(291.0, 38.0);

        root.getChildren().addAll(kembaliButton, textBox);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Successful Login");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
