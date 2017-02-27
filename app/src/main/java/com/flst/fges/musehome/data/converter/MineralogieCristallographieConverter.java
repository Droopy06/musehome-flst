package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.MineralogieCristallographie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class MineralogieCristallographieConverter {

    public ArrayList<MineralogieCristallographie> convertDtoTocristallographie(List<MineralogieCristallographie> mineralogieCristallographies){
        ArrayList<MineralogieCristallographie> list = new ArrayList<>();
        for(MineralogieCristallographie cristallographie : mineralogieCristallographies)
            list.add(cristallographie);
        return list;
    }
}
