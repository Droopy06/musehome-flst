package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.dto.CollectionDTO;
import com.flst.fges.musehome.data.model.Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class CollectionsConverter {

    public ArrayList<Collection> convertDtoToCollections(List<CollectionDTO> collections){
        ArrayList<Collection> list = new ArrayList<>();
        for(CollectionDTO collectionDTO : collections)
            list.add(convertDtoToCollection(collectionDTO));
        return list;
    }

    private Collection convertDtoToCollection(CollectionDTO collectionDTO){
        Collection collection = new Collection();
        collection.setFamille(collection.getFamille());
        collection.setImg("http://192.168.1.71:8090"+collectionDTO.getImg());
        collection.setNom(collectionDTO.getNom());
        collection.setUri(collectionDTO.getUri());
        collection.setUriadmin(collectionDTO.getUriadmin());
        return collection;
    }
}
