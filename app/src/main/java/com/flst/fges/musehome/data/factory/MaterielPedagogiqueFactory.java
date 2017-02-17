package com.flst.fges.musehome.data.factory;

import com.flst.fges.musehome.data.model.MaterielPedagogique;

import java.util.ArrayList;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class MaterielPedagogiqueFactory {

    public static ArrayList<MaterielPedagogique> getAllMaterielPedagogique(){
        ArrayList<MaterielPedagogique> materielPedagogiques = new ArrayList<>();
        materielPedagogiques.add(new MaterielPedagogique("ICL-PEDA-01","Materiel Pedagogique",
                                        "http://vps278022.ovh.net/patrimoine/images/Collections/pedaogique/ICL-PEDA-001.JPG",
                                        "Abeille"));
        materielPedagogiques.add(new MaterielPedagogique("ICL-PEDA-05","Materiel Pedagogique",
                                        "http://vps278022.ovh.net/patrimoine/images/Collections/pedaogique/ICL-PEDA-005.JPG",
                                        "Cerveau de chat"));
        return materielPedagogiques;
    }
}
