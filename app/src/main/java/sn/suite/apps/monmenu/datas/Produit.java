package sn.suite.apps.monmenu.datas;

/**
 * Created by Ninja barbu on 23/11/2017.
 */

public class Produit {
    private String nom;
    private String prix;
    private String type;

    public Produit(String nom, String prix,String type) {
        this.nom = nom;
        this.prix = prix;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
