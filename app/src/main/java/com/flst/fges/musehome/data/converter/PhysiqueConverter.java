package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.Physique;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class PhysiqueConverter {

    public ArrayList<Physique> convertDtoToPhysique(List<Physique> physiqueList){
        ArrayList<Physique> list = new ArrayList<>();
        for(Physique physique : physiqueList)
            list.add(physique);
        return list;
    }
}
