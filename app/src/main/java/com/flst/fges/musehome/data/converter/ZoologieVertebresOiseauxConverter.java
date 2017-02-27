package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.ZoologieVertebresOiseaux;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresOiseauxConverter {

    public ArrayList<ZoologieVertebresOiseaux> convertDtoToZoologieVertebresOiseaux(List<ZoologieVertebresOiseaux> zoologieVertebresOiseaux){
        ArrayList<ZoologieVertebresOiseaux> list = new ArrayList<>();
        for(ZoologieVertebresOiseaux invertebresOiseaux : zoologieVertebresOiseaux)
            list.add(invertebresOiseaux);
        return list;
    }
}
