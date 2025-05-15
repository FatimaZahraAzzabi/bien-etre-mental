package com.example.projet.model;

import java.time.LocalDate;

public class Utilisateur {
    private String prenom;
    private String nom;
    private String email;
    private String telephone;
    private LocalDate dateNaissance;
    private String genre;
    private String motDePasse;

    public Utilisateur(String prenom, String nom, String email, String telephone,
                       LocalDate dateNaissance, String genre, String motDePasse) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.motDePasse = motDePasse;
    }

    // Getters (optionnels, utiles pour affichage ou JSON)
    public String getPrenom() { return prenom; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
    public LocalDate getDateNaissance() { return dateNaissance; }
    public String getGenre() { return genre; }
    public String getMotDePasse() { return motDePasse; }

    // Setters (optionnels si tu veux modifier les valeurs plus tard)
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setNom(String nom) { this.nom = nom; }
    public void setEmail(String email) { this.email = email; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

}
