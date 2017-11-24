package sn.suite.apps.monmenu.datas;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ninja barbu on 22/11/2017.
 */

public class Resto implements Parcelable{

    private Integer ID;
    private String nom;
    private String adresse;
    private Integer imageID;
    private Boolean favori=false;

    public Resto() {
    }

    public Resto(Integer ID, String nom,String adresse, Integer imageID,Boolean favori) {
        this.ID = ID;
        this.nom = nom;
        this.adresse = adresse;
        this.imageID = imageID;
        this.favori=favori;
    }

    protected Resto(Parcel in) {
        nom = in.readString();
        adresse = in.readString();
        if (in.readByte() == 0) {
            imageID = null;
        } else {
            imageID = in.readInt();
        }
        byte tmpFavori = in.readByte();
        favori = tmpFavori == 0 ? null : tmpFavori == 1;
    }

    public static final Creator<Resto> CREATOR = new Creator<Resto>() {
        @Override
        public Resto createFromParcel(Parcel in) {
            return new Resto(in);
        }

        @Override
        public Resto[] newArray(int size) {
            return new Resto[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public Boolean isFavori() {
        return favori;
    }

    public void setFavori(Boolean favori) {
        this.favori = favori;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse= adresse;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeString(adresse);
        if (imageID == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(imageID);
        }
        parcel.writeByte((byte) (favori == null ? 0 : favori ? 1 : 2));
    }

    public Integer getID() {
        return ID;
    }
}
