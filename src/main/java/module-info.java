module com.shyrine.todolist.todolist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens com.shyrine.todolist.todolist to javafx.fxml;
    exports com.shyrine.todolist.todolist;
}