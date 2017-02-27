package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.ZoologieVertebresPrimates;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresPrimatesConverter {

    public ArrayList<ZoologieVertebresPrimates> convertDtoToZoologieVertebresPrimates(List<ZoologieVertebresPrimates> zoologieVertebresPrimates){
        ArrayList<ZoologieVertebresPrimates> list = new ArrayList<>();
        for(ZoologieVertebresPrimates invertebresPrimates : zoologieVertebresPrimates)
            list.add(invertebresPrimates);
        return list;
    }
}
