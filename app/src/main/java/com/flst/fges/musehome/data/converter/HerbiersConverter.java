package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.Herbiers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class HerbiersConverter {

    public ArrayList<Herbiers> convertDtoToHerbiers(List<Herbiers> herbiersList){
        ArrayList<Herbiers> list = new ArrayList<>();
        for(Herbiers herbiers : herbiersList)
            list.add(herbiers);
        return list;
    }
}
