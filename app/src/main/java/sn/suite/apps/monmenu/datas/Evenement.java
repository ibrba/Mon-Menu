package sn.suite.apps.monmenu.datas;

/**
 * Created by Ninja barbu on 22/11/2017.
 */

public class Evenement {

    private String date;
    private String descript;
    private Integer imageID;

    public Evenement() {
    }

    public Evenement(String date, String descript, Integer imageID) {
        this.date = date;
        this.descript = descript;
        this.imageID = imageID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }
}
