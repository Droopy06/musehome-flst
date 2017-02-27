package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.ZoologieVertebresAutres;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresAutresConverter {

    public ArrayList<ZoologieVertebresAutres> convertDtoToZoologieVertebresAutres(List<ZoologieVertebresAutres> zoologieVertebresAutres){
        ArrayList<ZoologieVertebresAutres> list = new ArrayList<>();
        for(ZoologieVertebresAutres invertebresAutres : zoologieVertebresAutres)
            list.add(invertebresAutres);
        return list;
    }
}
