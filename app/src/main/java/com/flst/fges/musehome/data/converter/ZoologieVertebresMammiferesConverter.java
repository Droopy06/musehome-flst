package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.ZoologieVertebresMammiferes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresMammiferesConverter {

    public ArrayList<ZoologieVertebresMammiferes> convertDtoToZoologieVertebresMammiferes(List<ZoologieVertebresMammiferes> zoologieVertebresMammiferes){
        ArrayList<ZoologieVertebresMammiferes> list = new ArrayList<>();
        for(ZoologieVertebresMammiferes invertebresMammiferes : zoologieVertebresMammiferes)
            list.add(invertebresMammiferes);
        return list;
    }
}
