package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.CollectionDetails;
import com.flst.fges.musehome.data.service.ICollectionsDetailsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class CollectionsDetailsManager {

    private ICollectionsDetailsService collectionsDetailsService;

    public CollectionsDetailsManager() {
        this.collectionsDetailsService = ServiceGenerator.createService(ICollectionsDetailsService.class);
    }

    public void getAllCollectionsDetails(final ICallback<List<CollectionDetails>> callback){
        final Call<List<CollectionDetails>> call = collectionsDetailsService.getAllCollectionsDetails();
        call.enqueue(new Callback<List<CollectionDetails>>() {
            @Override
            public void onResponse(Call<List<CollectionDetails>> call, Response<List<CollectionDetails>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<CollectionDetails>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }

    public void getCollectionsDetailsByName(String collection,final ICallback<CollectionDetails> callback){
        final Call<CollectionDetails> call = collectionsDetailsService.getCollectionsDetailByName(collection);
        call.enqueue(new Callback<CollectionDetails>() {
            @Override
            public void onResponse(Call<CollectionDetails> call, Response<CollectionDetails> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<CollectionDetails> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
