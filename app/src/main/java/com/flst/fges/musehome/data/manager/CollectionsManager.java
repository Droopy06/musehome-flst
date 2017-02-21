package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.converter.CollectionsConverter;
import com.flst.fges.musehome.data.dto.CollectionDTO;
import com.flst.fges.musehome.data.model.Collection;
import com.flst.fges.musehome.data.service.ICollectionsService;

import org.w3c.dom.ls.LSInput;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class CollectionsManager {

    private ICollectionsService collectionsService;

    public CollectionsManager() {
        this.collectionsService = ServiceGenerator.createService(ICollectionsService.class);
    }

    public void getAllCollections(final ICallback<List<Collection>> callback){
        final Call<List<CollectionDTO>> call = collectionsService.getAllCollections();
        call.enqueue(new Callback<List<CollectionDTO>>() {
            @Override
            public void onResponse(Call<List<CollectionDTO>> call, Response<List<CollectionDTO>> response) {
                if(response.isSuccessful() && response.body()!= null) {
                    CollectionsConverter collectionsConverter = new CollectionsConverter();
                    callback.success(collectionsConverter.convertDtoToCollections(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<CollectionDTO>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
