package sn.suite.apps.monmenu.datas;

/**
 * Created by Ninja barbu on 24/11/2017.
 */

public class Lieu {
    private double lat;
    private double lng;

    public Lieu(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
