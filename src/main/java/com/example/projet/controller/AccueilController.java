package com.example.projet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AccueilController {

    @FXML
    private void handleConnexion(ActionEvent event) {
        System.out.println("Bouton 'Se connecter' cliqué");
    }

    @FXML
    private void handleInscription(ActionEvent event) {
        System.out.println("Bouton 'S'inscrire' cliqué");
    }
}
