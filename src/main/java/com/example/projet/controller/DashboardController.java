package com.example.projet.controller;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;

public class DashboardController {

    @FXML
    private void handleLogout(ActionEvent event) {
        // Exemple simple : fermer la fenêtre du dashboard à la déconnexion
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        // Ici tu peux ajouter la logique pour revenir à la page de connexion, etc.
    }
}
