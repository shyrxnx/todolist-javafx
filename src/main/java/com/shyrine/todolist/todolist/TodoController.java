package com.shyrine.todolist.todolist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TodoController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("My name is Shyrine!");
    }
}