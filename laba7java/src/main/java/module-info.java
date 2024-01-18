module com.example.laba7java {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laba7java to javafx.fxml;
    exports com.example.laba7java;
}