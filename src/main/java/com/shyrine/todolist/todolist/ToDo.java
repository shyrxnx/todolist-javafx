package com.shyrine.todolist.todolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ToDo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ToDo.class.getResource("todo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 540);
        Image appIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/shyrine/todolist/todolist/images/todo_list_logo.png")));

        stage.setTitle("ToDoList by Shyrine");
        stage.getIcons().add(appIcon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}