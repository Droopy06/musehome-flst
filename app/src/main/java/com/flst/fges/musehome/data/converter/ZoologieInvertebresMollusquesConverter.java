package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.ZoologieInvertebresMollusques;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieInvertebresMollusquesConverter {

    public ArrayList<ZoologieInvertebresMollusques> convertDtoToZoologieInvertebresMollusques(List<ZoologieInvertebresMollusques> zoologieInvertebresMollusques){
        ArrayList<ZoologieInvertebresMollusques> list = new ArrayList<>();
        for(ZoologieInvertebresMollusques invertebresMollusques : zoologieInvertebresMollusques)
            list.add(invertebresMollusques);
        return list;
    }
}
