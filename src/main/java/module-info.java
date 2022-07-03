module com.juvimie {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;

    opens com.juvimie to javafx.fxml;
    exports com.juvimie;
}
