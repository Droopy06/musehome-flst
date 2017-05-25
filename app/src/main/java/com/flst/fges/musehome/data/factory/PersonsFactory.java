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
        personses.add(new Persons("Armand","Guillon","", R.drawable.armand,Persons.DEVELOPER_TYPE));
        personses.add(new Persons("Louis","Dupin","dupinlouis@gmail.com", R.drawable.louis,Persons.DEVELOPER_TYPE));
        personses.add(new Persons("Alexandre","Lamoot","lamootalexandre@gmail.com", R.drawable.alexandre,Persons.DEVELOPER_TYPE));
        personses.add(new Persons("Olive","Ndayizigiye","ndayizigiye.olive@gmail.com", R.drawable.olive,Persons.DEVELOPER_TYPE));
        return  personses;
    }

    public static ArrayList<Persons> getSupervision(){
        ArrayList<Persons> personses = new ArrayList<>();
        personses.add(new Persons("Benoit","Hubert","Benoit.HUBERT@univ-catholille.fr", R.drawable.benoit_hubert,Persons.OVERSIGHT_TYPE));
        personses.add(new Persons("Frédéric","Guilbert","Frederic.GUILBERT@univ-catholille.fr", R.drawable.guilbert_frederic,Persons.OVERSIGHT_TYPE));
        return  personses;
    }

    public static ArrayList<Persons> getAllPersons(){
        ArrayList<Persons> personses = new ArrayList<>();
        personses.add(new Persons("Benoit","Hubert","Benoit.HUBERT@univ-catholille.fr", R.drawable.benoit_hubert,Persons.OVERSIGHT_TYPE));
        personses.add(new Persons("Frédéric","Guilbert","Frederic.GUILBERT@univ-catholille.fr", R.drawable.guilbert_frederic,Persons.OVERSIGHT_TYPE));
        personses.add(new Persons("Armand","Guillon","", R.drawable.armand,Persons.DEVELOPER_TYPE));
        personses.add(new Persons("Louis","Dupin","dupinlouis@gmail.com", R.drawable.louis,Persons.DEVELOPER_TYPE));
        personses.add(new Persons("Alexandre","Lamoot","lamootalexandre@gmail.com", R.drawable.alexandre,Persons.DEVELOPER_TYPE));
        personses.add(new Persons("Olive","Ndayizigiye","ndayizigiye.olive@gmail.com", R.drawable.olive,Persons.DEVELOPER_TYPE));
        return personses;
    }

}
