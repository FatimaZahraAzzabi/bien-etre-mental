package com.example.projet.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.example.projet.Module.Utilisateur;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule; // 📌 Import nécessaire

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ConnexionController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    // Fonction pour gérer la connexion
    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            // Charger le fichier JSON contenant les utilisateurs
            File file = new File("src/main/resources/users.json");

            // Création de l'ObjectMapper avec le module JavaTime pour LocalDate
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            // Lecture de la liste des utilisateurs
            List<Utilisateur> users = mapper.readValue(
                    file, mapper.getTypeFactory().constructCollectionType(List.class, Utilisateur.class)
            );

            boolean userExists = false;
            for (Utilisateur user : users) {
                if (user.getEmail().equals(username) && user.getMotDePasse().equals(password)) {
                    userExists = true;
                    break;
                }
            }

            if (userExists) {
                loadDashboard();
                System.out.println("Utilisateur trouvé, redirection vers le dashboard...");
            } else {
                showError("Nom d'utilisateur ou mot de passe incorrect.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            showError("Erreur lors de la lecture des utilisateurs.");
        }
    }

    // Affichage d’un message d’erreur
    private void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setVisible(true); // 👈 indispensable !
    }

    // Chargement de la vue du tableau de bord
    private void loadDashboard() {
        try {
            URL fxmlLocation = getClass().getResource("/com/example/projet/view/dashboard.fxml");
            if (fxmlLocation == null) {
                throw new IllegalStateException("Fichier FXML introuvable à l'emplacement spécifié.");
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Scene dashboardScene = new Scene(loader.load());

            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.setScene(dashboardScene);
            currentStage.setTitle("Tableau de bord");
            currentStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showError("Erreur lors du chargement du tableau de bord : " + e.getMessage());
        } catch (IllegalStateException e) {
            e.printStackTrace();
            showError("Fichier FXML manquant : " + e.getMessage());
        }
    }
}
