package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.PaleontologieAnimale;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class PaleontologieAnimaleConverter {

    public ArrayList<PaleontologieAnimale> convertDtoToPaleontologieAnimale(List<PaleontologieAnimale> paleontologieAnimales){
        ArrayList<PaleontologieAnimale> list = new ArrayList<>();
        for(PaleontologieAnimale paleontologieAnimale : paleontologieAnimales)
            list.add(paleontologieAnimale);
        return list;
    }
}
