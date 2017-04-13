package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.dto.EvenementDTO;
import com.flst.fges.musehome.data.helper.UrlHelper;
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

    public Evenement convertDtoToEvenement(EvenementDTO evenementDTO){
        Evenement evenement = new Evenement();
        evenement.setTitre(evenementDTO.getTitre());
        evenement.setMiniDescr(evenementDTO.getMiniDescr());
        evenement.setImageuri("http://"+ UrlHelper.BASE_URL_API+evenementDTO.getImageuri());
        evenement.setMiniimageuri("http://1"+ UrlHelper.BASE_URL_API+evenementDTO.getMiniimageuri());
        evenement.setFacebook(evenementDTO.getFacebook());
        evenement.setGo(evenementDTO.getGo());
        evenement.setTwitter(evenementDTO.getTwitter());
        return evenement;
    }
}
