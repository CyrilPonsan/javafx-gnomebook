package fr.firiz.modele.data;

public class Gnome {

    private String nom;
    private String metier;

    public Gnome(String nom, String metier) {
        this.nom = nom;
        this.metier = metier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

}
