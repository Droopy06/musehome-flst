package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.MaterielPedagogique;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class MaterielPedagogiqueConverter {

    public ArrayList<MaterielPedagogique> convertDtoToMaterielPedagogique(List<MaterielPedagogique> materielPedagogiques){
        ArrayList<MaterielPedagogique> list = new ArrayList<>();
        for(MaterielPedagogique materielPedagogique : materielPedagogiques)
            list.add(materielPedagogique);
        return list;
    }
}
