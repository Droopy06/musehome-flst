package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.Petrographie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class PetrographieConverter {

    public ArrayList<Petrographie> convertDtoToPetrographie(List<Petrographie> petrographieList){
        ArrayList<Petrographie> list = new ArrayList<>();
        for(Petrographie petrographie : petrographieList)
            list.add(petrographie);
        return list;
    }
}
