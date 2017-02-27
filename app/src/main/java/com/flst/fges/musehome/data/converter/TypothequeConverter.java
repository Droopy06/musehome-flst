package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.Typotheque;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class TypothequeConverter {

    public ArrayList<Typotheque> convertDtoToTypotheque(List<Typotheque> typothequeList){
        ArrayList<Typotheque> list = new ArrayList<>();
        for(Typotheque typotheque : typothequeList)
            list.add(typotheque);
        return list;
    }
}
