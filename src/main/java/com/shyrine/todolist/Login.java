package com.shyrine.todolist;

import com.shyrine.todolist.util.SQLiteConnectionUtil;
import com.shyrine.todolist.util.SceneUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Login extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SQLiteConnectionUtil.getConnection();
        Scene scene = SceneUtils.createScene("com/shyrine/todolist/login.fxml", 960, 540);

        stage.setTitle("ToDoList by Shyrine");
        stage.getIcons().add(SceneUtils.loadApplicationIcon());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void stop() {
        SQLiteConnectionUtil.closeConnection();
    }

    public static void main(String[] args) {
        launch();
    }
}