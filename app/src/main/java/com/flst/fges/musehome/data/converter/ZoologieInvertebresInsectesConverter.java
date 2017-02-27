package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.ZoologieInvertebresInsectes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieInvertebresInsectesConverter {

    public ArrayList<ZoologieInvertebresInsectes> convertDtoToZoologieInvertebresInsectes(List<ZoologieInvertebresInsectes> zoologieInvertebresInsectes){
        ArrayList<ZoologieInvertebresInsectes> list = new ArrayList<>();
        for(ZoologieInvertebresInsectes invertebresInsectes : zoologieInvertebresInsectes)
            list.add(invertebresInsectes);
        return list;
    }
}
