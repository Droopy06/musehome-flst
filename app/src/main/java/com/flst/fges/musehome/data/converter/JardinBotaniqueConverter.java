package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.JardinBotanique;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class JardinBotaniqueConverter {

    public ArrayList<JardinBotanique> convertDtoToJardinBotanique(List<JardinBotanique> jardinBotaniques){
        ArrayList<JardinBotanique> list = new ArrayList<>();
        for(JardinBotanique jardinBotanique : jardinBotaniques)
            list.add(jardinBotanique);
        return list;
    }
}
