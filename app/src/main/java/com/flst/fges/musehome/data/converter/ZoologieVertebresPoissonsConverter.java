package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.ZoologieVertebresPoissons;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresPoissonsConverter {

    public ArrayList<ZoologieVertebresPoissons> convertDtoToZoologieVertebresPoissons(List<ZoologieVertebresPoissons> zoologieVertebresPoissonses){
        ArrayList<ZoologieVertebresPoissons> list = new ArrayList<>();
        for(ZoologieVertebresPoissons zoologieVertebresPoissons : zoologieVertebresPoissonses)
            list.add(zoologieVertebresPoissons);
        return list;
    }
}
