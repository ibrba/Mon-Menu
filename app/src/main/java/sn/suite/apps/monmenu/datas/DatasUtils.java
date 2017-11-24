package sn.suite.apps.monmenu.datas;

import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import sn.suite.apps.monmenu.R;

/**
 * Created by Ninja barbu on 23/11/2017.
 */

public class DatasUtils {

    private static final Resto restos[] = {
            new Resto( 1,"O Bien Etre","Dakar",R.drawable.obienetre,false),
            new Resto(2,"Aux fins palais","Dakar",R.drawable.aux_fins_palais,false),
            new Resto(3,"Chick'N","Dakar", R.drawable.chickn,false),
            new Resto(4, "CIAO ITALIA","Dakar", R.drawable.ciao,true),
            new Resto(5,"Ci Gusta","Dakar",R.drawable.ci_gusta,true),
            new Resto(6,"Esprit Sushi","Dakar", R.drawable.espirit_sushi,false),
            new Resto(7,"Kaysar","Dakar",R.drawable.kaysar,true),
            new Resto(8,"Andaloss","Dakar",R.drawable.aux_fins_palais,false),
            new Resto( 9, "Classic Burger","Dakar",R.drawable.classic_burger,false),
    };


    private static final String CHAUDE = "chaude";
    private static final String FROIDE = "froide";
    private static final String EAU = "eau";

    private static final Produit[] produits = {
            new Produit("Nrespresso","2 000", CHAUDE),
            new Produit("Espresso","1 600", CHAUDE),
            new Produit("Capushino","1 000", CHAUDE),
            new Produit("Cafe","2 000", CHAUDE),
            new Produit("Ataya","250", CHAUDE),
            new Produit("JUS","2 000", FROIDE),
            new Produit("Nrespresso","2 000", CHAUDE),
            new Produit("Nrespresso","2 000", CHAUDE),
            new Produit("Nrespresso","2 000", CHAUDE),
    };
    private static final SiteResto[] sitesResto = {
            new SiteResto("1","O Bien Etre Almadies","Almadies, Route de Ngor en face pharmacie La Gironde", "Lundi au Dimanche: 06:00 - 23:30", "+221 33 820 54 44"),
            new SiteResto("1","O Bien Etre Fann","Avenue Birago DIOP, Point E", "Lundi au Dimanche: 06:00 - 23:30", "+221 33 820 54 44"),
    };

    private static final Evenement[] fackEvents = {
            new Evenement("Mardi 14 Novembre 2017 - 20:30","Veuillez mettre ici les détails de l’événement.\n" +
                    "Un texte explicite about the event.",R.drawable.event1),
            new Evenement("Mardi 14 Novembre 2017 - 20:30","Veuillez mettre ici les détails de l’événement.\n" +
                    "Un texte explicite about the event.",R.drawable.event2),
            new Evenement("Mardi 14 Novembre 2017 - 20:30","Veuillez mettre ici les détails de l’événement.\n" +
                    "Un texte explicite about the event.",R.drawable.event3),
    };


    public static final Lieu [] lieux = {
            new Lieu(14.740215, -17.429895),
            new Lieu(14.728262, -17.449808),
            new Lieu(14.711991, -17.481050),
            new Lieu(14.749511, -17.509546),
            new Lieu(14.701531, -17.468691),
            new Lieu(14.728594, -17.466459),
            new Lieu(14.710497, -17.454958)
    };

    public static ArrayList<Resto> loadRestos(){

        ArrayList<Resto> listRestos = new ArrayList<>();
        for(int i = 0; i< restos.length; i++){
            listRestos.add(restos[i]);
        }
        return listRestos;
    }

    public static List<Produit> loadBoissonsChaudes() {
        ArrayList<Produit> chaudes = new ArrayList<>();
        for(int i = 0; i< produits.length; i++){
            if(produits[i].getType()==CHAUDE)
                chaudes.add(produits[i]);
        }
        return chaudes;
    }

    public static ArrayList<SiteResto> loadSites() {
        ArrayList<SiteResto> sites = new ArrayList<>();
        for(int i = 0; i< sitesResto.length; i++){
                sites.add(sitesResto[i]);
        }
        return sites;
    }

    public static ArrayList<Evenement> loadEvents() {
        ArrayList<Evenement> events = new ArrayList<>();
        for(int i = 0; i< fackEvents.length; i++){
            events.add(fackEvents[i]);
        }
        return events;
    }

    public static Resto getResto(Integer idResto) {
        for(int i = 0; i< restos.length; i++){
            if(restos[i].getID()==idResto)
                return restos[i];
        }
        return null;
    }
}
