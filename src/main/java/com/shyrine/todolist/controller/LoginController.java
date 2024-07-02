package com.shyrine.todolist.controller;

import com.shyrine.todolist.util.UserDetailsService;
import com.shyrine.todolist.util.UserDetailsService.LoginResult;
import com.shyrine.todolist.util.SceneUtils;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    private UserDetailsService userDetailsService;

    public void initialize() {
        userDetailsService = new UserDetailsService();

        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            LoginResult result = userDetailsService.validateUser(username, password);

            switch (result) {
                case SUCCESS -> redirectToSidebar();
                case INVALID_USERNAME -> showAlert("Login Failed", "Invalid username.");
                case INVALID_PASSWORD -> showAlert("Login Failed", "Invalid password.");
                case DATABASE_ERROR -> showAlert("Error", "Database error occurred. Please try again later.");
            }
        });
    }

    private void redirectToSidebar() {
        try {
            Stage stage = (Stage) loginButton.getScene().getWindow(); // Get the current stage

            // Create a fade-out transition for the current scene
            FadeTransition fadeOut = new FadeTransition(Duration.millis(500), loginButton.getScene().getRoot());
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(event -> {
                try {
                    // Load the sidebar scene
                    Scene scene = SceneUtils.createScene("com/shyrine/todolist/sidebar.fxml", 960, 540);
                    stage.setTitle("ToDoList by Shyrine");
                    stage.getIcons().add(SceneUtils.loadApplicationIcon());
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();

                    // Create a fade-in transition for the new scene
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(500), scene.getRoot());
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);
                    fadeIn.play();
                } catch (IOException e) {
                    showAlert("Error", "Failed to load sidebar scene: " + e.getMessage());
                    e.printStackTrace(); // Handle the exception appropriately in your application
                }
            });

            // Play the fade-out transition
            fadeOut.play();

        } catch (Exception e) {
            showAlert("Error", "Failed to redirect to sidebar: " + e.getMessage());
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }



    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource("/com/shyrine/todolist/images/todo_list_logo.png")).toString()));

        alert.showAndWait();
    }
}
