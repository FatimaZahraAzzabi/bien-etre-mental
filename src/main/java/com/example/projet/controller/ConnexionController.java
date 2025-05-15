package com.example.projet.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import com.example.projet.Module.Utilisateur;
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

        // Charger les utilisateurs depuis un fichier JSON
        try {
            // Charger le fichier JSON contenant les utilisateurs (assurez-vous que le fichier existe)
            File file = new File("src/main/resources/users.json");
            // Remplacez par le bon chemin
            ObjectMapper mapper = new ObjectMapper();
            List<Utilisateur> users = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Utilisateur.class));

            // Vérifier si l'utilisateur existe
            boolean userExists = false;
            for (Utilisateur user : users) {
                if (user.getEmail().equals(username) && user.getMotDePasse().equals(password)) {
                    userExists = true;
                    break;
                }
            }

            // Si l'utilisateur existe, rediriger vers le tableau de bord
            if (userExists) {
                // Rediriger vers le tableau de bord ici, par exemple :
                 loadDashboard();
                System.out.println("Utilisateur trouvé, redirection vers le dashboard...");
            } else {
                // Si l'utilisateur n'existe pas, afficher un message d'erreur
                showError("Nom d'utilisateur ou mot de passe incorrect.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            showError("Erreur lors de la lecture des utilisateurs.");
        }
    }

    // Fonction pour afficher un message d'erreur dans la page de connexion
    private void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setStyle("-fx-text-fill: red;");
    }


    // Fonction pour rediriger vers le tableau de bord
    private void loadDashboard() {
        try {
            // Chargement sécurisé du fichier FX
            URL fxmlLocation = getClass().getResource("/com/example/projet/view/dashboard.fxml");
            if (fxmlLocation == null) {
                throw new IllegalStateException("Fichier FXML introuvable à l'emplacement spécifié.");
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Scene dashboardScene = new Scene(loader.load());

            // Récupération de la fenêtre actuelle (connexion)
            Stage currentStage = (Stage) usernameField.getScene().getWindow();

            // Changement de scène
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










