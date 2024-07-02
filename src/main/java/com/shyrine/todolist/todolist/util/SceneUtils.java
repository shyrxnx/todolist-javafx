package com.shyrine.todolist.todolist.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

public class SceneUtils {
    public static Image loadApplicationIcon() {
        return new Image(Objects.requireNonNull(SceneUtils.class.getResourceAsStream("/com/shyrine/todolist/todolist/images/todo_list_logo.png")));
    }

    public static Scene createScene(String fxmlPath, double width, double height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneUtils.class.getResource("/" + fxmlPath));
        Pane pane = fxmlLoader.load();
        return new Scene(pane, width, height);
    }
}
