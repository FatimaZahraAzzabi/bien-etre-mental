
package com.example.projet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AccueilController {

    @FXML
    private void handleInscription(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projet/view/inscription.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Récupérer les dimensions actuelles de la scène
            double largeur = stage.getScene().getWidth();
            double hauteur = stage.getScene().getHeight();

            // Créer la nouvelle scène avec les mêmes dimensions
            Scene scene = new Scene(root, largeur, hauteur);
            stage.setScene(scene);
            stage.setTitle("Inscription");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleConnexion(ActionEvent event) {
        // Tu pourras ajouter la page de connexion plus tard ici
    }
}
