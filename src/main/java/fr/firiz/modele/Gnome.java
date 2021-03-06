package fr.firiz.modele;

public class Gnome {

    private final String nom;
    private final String metier;
    private final int niveau;
    private String avatar;

    public Gnome(String nom, String metier, int niveau) {
        this.nom = nom;
        this.metier = metier;
        this.niveau = niveau;
        this.avatar = avatar;
    }

    public String getNom() {
        return nom;
    }

    public String getMetier() {
        return metier;
    }

    public String getNiveau() {
        return String.valueOf(niveau);
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String url) {
        this.avatar = url.replaceFirst(".", "http://localhost/gnomeBook");
    }
}
