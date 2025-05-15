package com.example.projet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // Chargement de la page d'accueil Calmora
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projet/view/accueil.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 800, 600); // Taille par défaut
            stage.setTitle("Calmora - Bien-être mental");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace(); // Affiche les erreurs dans la console
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
