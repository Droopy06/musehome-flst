package com.flst.fges.musehome.data.factory;

import com.flst.fges.musehome.data.model.Evenement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class EvenementFactory {

    public static ArrayList<Evenement> getAllEvenement(){
        ArrayList<Evenement> evenementList = new ArrayList<>();
        evenementList.add(new Evenement("Evenement 01","Ceci est un exemple d'évenement de niveau 1",
                            "http://vps278022.ovh.net/patrimoine/images/Evenements/evenement01.png",
                "http://vps278022.ovh.net/patrimoine/images/Evenements/evenement01.png","","",""));
        evenementList.add(new Evenement("Evenement 02","Ceci est un exemple d'évenement de niveau 2",
                "http://vps278022.ovh.net/patrimoine/images/Evenements/evenement02.png",
                "http://vps278022.ovh.net/patrimoine/images/Evenements/evenement02.png","","",""));
        evenementList.add(new Evenement("Evenement 03","Ceci est un exemple d'évenement de niveau 3",
                "http://vps278022.ovh.net/patrimoine/images/Evenements/evenement03.png",
                "http://vps278022.ovh.net/patrimoine/images/Evenements/evenement03.png","","",""));
        evenementList.add(new Evenement("Evenement 04","Ceci est un exemple d'évenement de niveau 3",
                "http://vps278022.ovh.net/patrimoine/images/Evenements/evenement04.png",
                "http://vps278022.ovh.net/patrimoine/images/Evenements/evenement04.png","","",""));
        return evenementList;
    }
}
