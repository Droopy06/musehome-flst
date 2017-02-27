package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.DefaultClassCollection;
import com.flst.fges.musehome.data.service.IDefaultClassCollectionService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class DefaultClassCollectionManager {

    private IDefaultClassCollectionService defaultClassCollectionService;

    public DefaultClassCollectionManager() {
        this.defaultClassCollectionService = ServiceGenerator.createService(IDefaultClassCollectionService.class);
    }

    public void getDefaultClassCollectionByName(String collection,String object,final ICallback<DefaultClassCollection> callback){
        final Call<DefaultClassCollection> call = defaultClassCollectionService.getObjectCollectionByName(collection,object);
        call.enqueue(new Callback<DefaultClassCollection>() {
            @Override
            public void onResponse(Call<DefaultClassCollection> call, Response<DefaultClassCollection> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<DefaultClassCollection> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
