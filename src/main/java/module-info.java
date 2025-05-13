module com.example.projet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projet.controller to javafx.fxml;
    exports com.example.projet;
}