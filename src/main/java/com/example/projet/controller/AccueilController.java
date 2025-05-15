package com.example.projet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AccueilController {

    @FXML
    public void handleConnexion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projet/view/connexion.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage(); // nouvelle fenêtre
            stage.setTitle("Connexion");
            stage.setScene(new Scene(root));
            stage.show();

            // Si tu veux fermer la page actuelle (optionnel) :
            ((Node) event.getSource()).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleInscription(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projet/view/inscription.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            double largeur = stage.getScene().getWidth();
            double hauteur = stage.getScene().getHeight();

            Scene scene = new Scene(root, largeur, hauteur);
            stage.setScene(scene);
            stage.setTitle("Inscription");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
