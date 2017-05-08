package com.flst.fges.musehome.data.factory;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.model.Persons;

import java.util.ArrayList;

/**
 * Created by LAMOOT Alexandre on 02/04/2017.
 */

public class PersonsFactory {

    public static ArrayList<Persons> getDevelopers(){
        ArrayList<Persons> personses = new ArrayList<>();
        personses.add(new Persons("Armand","Guillon","", R.drawable.armand));
        personses.add(new Persons("Louis","Dupin","dupinlouis@gmail.com", R.drawable.louis));
        personses.add(new Persons("Alexandre","Lamoot","lamootalexandre@gmail.com", R.drawable.alexandre));
        personses.add(new Persons("Olive","Ndayizigiye","ndayizigiye.olive@gmail.com", R.drawable.olive));
        return  personses;
    }

    public static ArrayList<Persons> getSupervision(){
        ArrayList<Persons> personses = new ArrayList<>();
        personses.add(new Persons("Benoit","Hubert","Benoit.HUBERT@univ-catholille.fr", R.drawable.benoit_hubert));
        personses.add(new Persons("Frédéric","Guilbert","Frederic.GUILBERT@univ-catholille.fr", R.drawable.guilbert_frederic));
        return  personses;
    }
}
