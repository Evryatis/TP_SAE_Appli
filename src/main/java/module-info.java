module com.example.aaaaaaa {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.aaaaaaa to javafx.fxml;
    exports com.example.aaaaaaa;
    exports vue;
}