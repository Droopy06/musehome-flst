package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.ZoologieVertebresReptile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresReptileConverter {

    public ArrayList<ZoologieVertebresReptile> convertDtoToZoologieVertebresReptile(List<ZoologieVertebresReptile> zoologieVertebresReptile){
        ArrayList<ZoologieVertebresReptile> list = new ArrayList<>();
        for(ZoologieVertebresReptile invertebresReptile : zoologieVertebresReptile)
            list.add(invertebresReptile);
        return list;
    }
}
