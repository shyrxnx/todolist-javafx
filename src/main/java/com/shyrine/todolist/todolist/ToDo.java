package com.shyrine.todolist.todolist;

import com.shyrine.todolist.todolist.util.SceneUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ToDo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = SceneUtils.createScene("com/shyrine/todolist/todolist/todo-view.fxml", 960, 540);

        stage.setTitle("ToDoList by Shyrine");
        stage.getIcons().add(SceneUtils.loadApplicationIcon());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}