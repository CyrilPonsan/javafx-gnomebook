package fr.firiz.modele;

public class Gnome {

    private String nom;
    private String metier;
    private int niveau;
    private String avatar;

    public Gnome(String nom, String metier, int niveau, String avatar) {
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
        //this.avatar = url.replaceFirst("./", "./src/main/java/");
    }
}
