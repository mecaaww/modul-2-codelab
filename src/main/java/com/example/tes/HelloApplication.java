package com.example.tes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {

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

        Text titleText = new Text("Halaman Login");
        titleText.setFill(Color.web("#840c4c"));
        titleText.setFont(Font.font("MV Boli", 45));
        titleText.setUnderline(true);
        titleText.setWrappingWidth(356.5367431640625567);

        VBox titleBox = new VBox(titleText);
        titleBox.setLayoutX(-1.0);
        titleBox.setLayoutY(14.0);
        titleBox.setPrefSize(358.0, 71.0);


        Text userNameText = new Text("User Name      :");
        userNameText.setFill(Color.web("#811b67"));
        userNameText.setFont(Font.font("Berlin Sans FB", 21));
        userNameText.setWrappingWidth(148.1064453125);

        VBox userNameBox = new VBox(userNameText);
        userNameBox.setLayoutX(26.0);
        userNameBox.setLayoutY(119.0);
        userNameBox.setPrefSize(135.0, 30.0);


        TextField userNameField = new TextField();
        userNameField.setLayoutX(178.0);
        userNameField.setLayoutY(125.0);
        userNameField.setPrefSize(150.0, 29.0);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(new Color(0, 0, 0, 0.6238601803779602));
        userNameField.setEffect(dropShadow);

        Text passwordText = new Text("Password          :");
        passwordText.setFill(Color.web("#811b67"));
        passwordText.setFont(Font.font("Berlin Sans FB", 20));
        passwordText.setWrappingWidth(148.1064453125);

        VBox passwordBox = new VBox(passwordText);
        passwordBox.setLayoutX(26.0);
        passwordBox.setLayoutY(162.0);
        passwordBox.setPrefSize(135.0, 30.0);


        TextField passwordField = new TextField();
        passwordField.setLayoutX(178.0);
        passwordField.setLayoutY(162.0);
        passwordField.setPrefSize(150.0, 30.0);
        passwordField.setEffect(dropShadow);

        Button signInButton = new Button("Sign in");
        signInButton.setLayoutX(249.0);
        signInButton.setLayoutY(228.0);
        signInButton.setPrefSize(78.0, 30.0);
        signInButton.setFont(Font.font("OCR A Extended", 14));
        signInButton.setBackground(Background.fill(Color.LIGHTPINK));
        signInButton.setTextFill(Color.PURPLE);


        Text errorMessage = new Text();
        errorMessage.setFill(Color.web("#dc0202"));
        errorMessage.setFont(Font.font("Nirmala UI", 14));

        VBox errorBox = new VBox(errorMessage);
        errorBox.setLayoutX(26.0);
        errorBox.setLayoutY(276.0);
        errorBox.setPrefSize(213.0, 20.0);

        signInButton.setOnAction(actionEvent -> {
            String username = userNameField.getText();
            String password = passwordField.getText();
            if(username.isEmpty()  ||  password.isEmpty()){
                if(username.isEmpty() && password.isEmpty()){
                    errorMessage.setText("Username dan Password Kosong");
                }else if(username.isEmpty()){
                    errorMessage.setText("Username Kosong");
                }else{
                    errorMessage.setText("Password Kosong");
                }
            }else{
                if(username.equals("202310370311425")){
                    if(password.equals("password425")){
                        HalamanKedua andaBerhasil = new HalamanKedua();
                        andaBerhasil.start(primaryStage);
                    }else{
                        errorMessage.setText("Password Salah");
                    }
                }else{
                    errorMessage.setText("Username Salah");
                }
            }
        });

        root.getChildren().addAll(titleBox, userNameBox, userNameField, passwordBox, passwordField, signInButton, errorBox);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Page");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
