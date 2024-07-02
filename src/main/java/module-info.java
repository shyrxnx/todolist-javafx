module com.shyrine.todolist.todolist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens com.shyrine.todolist to javafx.fxml;
    exports com.shyrine.todolist;
    exports com.shyrine.todolist.controller;
    opens com.shyrine.todolist.controller to javafx.fxml;
}