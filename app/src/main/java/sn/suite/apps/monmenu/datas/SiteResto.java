package sn.suite.apps.monmenu.datas;

/**
 * Created by Ninja barbu on 23/11/2017.
 */

public class SiteResto {
    private String idResto;
    private String nom;
    private String adress;
    private String horaire;
    private String tel;

    public SiteResto(String idResto, String nom, String adress, String horaire, String tel) {
        this.idResto = idResto;
        this.nom = nom;
        this.adress = adress;
        this.horaire = horaire;
        this.tel = tel;
    }

    public String getIdResto() {
        return idResto;
    }

    public void setIdResto(String idResto) {
        this.idResto = idResto;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
