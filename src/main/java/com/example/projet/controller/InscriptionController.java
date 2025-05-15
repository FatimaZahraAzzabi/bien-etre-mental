package com.example.projet.controller;

import com.example.projet.model.Utilisateur;
import com.example.projet.util.FileManager;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InscriptionController {

    @FXML private TextField champNom;
    @FXML private TextField champPrenom;
    @FXML private TextField champEmail;
    @FXML private TextField champTelephone;
    @FXML private ComboBox<String> champGenre;
    @FXML private PasswordField champMotDePasse;
    @FXML private PasswordField champMotDePasseConfirme;
    @FXML private DatePicker champDateNaissance;
    @FXML private Label messageLabel;

    private static final String FICHIER = "src/main/resources/users.json";
    private List<Utilisateur> utilisateurs;

    @FXML
    public void initialize() {
        File file = new File(FICHIER);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("[]"); // tableau JSON vide
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        utilisateurs = FileManager.charger(FICHIER, new TypeToken<List<Utilisateur>>(){}.getType());
        if (utilisateurs == null) {
            utilisateurs = new ArrayList<>();
        }
    }

    @FXML
    public void validerInscription() {
        String prenom = champPrenom.getText();
        String nom = champNom.getText();
        String email = champEmail.getText();
        String telephone = champTelephone.getText();
        String genre = champGenre.getValue();
        String motDePasse = champMotDePasse.getText();
        String motDePasseConfirme = champMotDePasseConfirme.getText();
        LocalDate dateNaissance = champDateNaissance.getValue();

        if (prenom.isEmpty() || nom.isEmpty() || email.isEmpty() || motDePasse.isEmpty() || motDePasseConfirme.isEmpty()) {
            messageLabel.setText("Tous les champs obligatoires doivent être remplis.");
            return;
        }

        if (!motDePasse.equals(motDePasseConfirme)) {
            messageLabel.setText("Les mots de passe ne correspondent pas.");
            return;
        }

        for (Utilisateur u : utilisateurs) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                messageLabel.setText("Cet email est déjà utilisé.");
                return;
            }
        }

        Utilisateur utilisateur = new Utilisateur(prenom, nom, email, telephone, dateNaissance, genre, motDePasse);
        utilisateurs.add(utilisateur);
        FileManager.sauvegarder(utilisateurs, FICHIER);

        messageLabel.setStyle("-fx-text-fill: green;");
        messageLabel.setText("Inscription réussie !");

        // Nettoyage des champs
        champPrenom.clear();
        champNom.clear();
        champEmail.clear();
        champTelephone.clear();
        champMotDePasse.clear();
        champMotDePasseConfirme.clear();
        champDateNaissance.setValue(null);
        champGenre.setValue(null);
    }
}
