package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.dto.EvenementDTO;
import com.flst.fges.musehome.data.model.Evenement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class EvenementsConverter {

    public ArrayList<Evenement> convertDtoToEvenements(List<EvenementDTO> evenements){
        ArrayList<Evenement> list = new ArrayList<>();
        for(EvenementDTO evenementDTO : evenements)
            list.add(convertDtoToEvenement(evenementDTO));
        return list;
    }

    private Evenement convertDtoToEvenement(EvenementDTO evenementDTO){
        Evenement evenement = new Evenement();
        evenement.setTitre(evenementDTO.getTitre());
        evenement.setMiniDescr(evenementDTO.getMiniDescr());
        evenement.setImageuri("http://192.168.1.71:8090"+evenementDTO.getImageuri());
        evenement.setMiniimageuri("http://192.168.1.71:8090"+evenementDTO.getMiniimageuri());
        evenement.setFacebook(evenementDTO.getFacebook());
        evenement.setGo(evenementDTO.getGo());
        evenement.setTwitter(evenementDTO.getTwitter());
        return evenement;
    }
}
