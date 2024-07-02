package com.shyrine.todolist.controller;

import com.shyrine.todolist.util.UserDetailsService;
import com.shyrine.todolist.util.UserDetailsService.LoginResult;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
                case SUCCESS -> showAlert("Login Successful", "Welcome, " + username + "!");
                case INVALID_USERNAME -> showAlert("Login Failed", "Invalid username.");
                case INVALID_PASSWORD -> showAlert("Login Failed", "Invalid password.");
                case DATABASE_ERROR -> showAlert("Error", "Database error occurred. Please try again later.");
            }
        });
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
