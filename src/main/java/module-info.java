module com.example.projet {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens com.example.projet.controller to javafx.fxml;
    opens com.example.projet.Module to com.fasterxml.jackson.databind;

    exports com.example.projet;
    exports com.example.projet.controller;
    exports com.example.projet.Module to com.fasterxml.jackson.databind;

}