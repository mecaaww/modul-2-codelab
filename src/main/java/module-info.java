module com.example.tes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tes to javafx.fxml;
    exports com.example.tes;
}