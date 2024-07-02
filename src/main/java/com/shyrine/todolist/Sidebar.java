package com.shyrine.todolist;

import com.shyrine.todolist.util.SceneUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Sidebar extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = SceneUtils.createScene("com/shyrine/todolist/sidebar.fxml", 960, 540);

        stage.setTitle("ToDoList by Shyrine");
        stage.getIcons().add(SceneUtils.loadApplicationIcon());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}