module com.example.laba33 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laba33 to javafx.fxml;
    exports com.example.laba33;
}