package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.Instruments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class InstrumentsConverter {

    public ArrayList<Instruments> convertDtoToInstruments(List<Instruments> instrumentsList){
        ArrayList<Instruments> list = new ArrayList<>();
        for(Instruments instruments : instrumentsList)
            list.add(instruments);
        return list;
    }
}
