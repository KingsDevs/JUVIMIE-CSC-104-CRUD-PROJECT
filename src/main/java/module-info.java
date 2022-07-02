module com.juvimie {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.juvimie to javafx.fxml;
    exports com.juvimie;
}
