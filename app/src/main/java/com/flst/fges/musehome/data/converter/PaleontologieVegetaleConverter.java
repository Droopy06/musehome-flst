package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.PaleontologieVegetale;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class PaleontologieVegetaleConverter {

    public ArrayList<PaleontologieVegetale> convertDtoToPaleontologieVegetale(List<PaleontologieVegetale> paleontologieVegetales){
        ArrayList<PaleontologieVegetale> list = new ArrayList<>();
        for(PaleontologieVegetale paleontologieVegetale : paleontologieVegetales)
            list.add(paleontologieVegetale);
        return list;
    }
}
