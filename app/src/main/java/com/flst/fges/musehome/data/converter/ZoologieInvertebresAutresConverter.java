package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.ZoologieInvertebresAutres;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieInvertebresAutresConverter {

    public ArrayList<ZoologieInvertebresAutres> convertDtoToZoologieInvertebresAutres(List<ZoologieInvertebresAutres> zoologieInvertebresAutres){
        ArrayList<ZoologieInvertebresAutres> list = new ArrayList<>();
        for(ZoologieInvertebresAutres invertebresAutres : zoologieInvertebresAutres)
            list.add(invertebresAutres);
        return list;
    }
}
