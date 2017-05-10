package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.ZoologieInvertebresAutres;
import com.flst.fges.musehome.data.service.IZoologieInvertebresAutresService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieInvertebresAutresManager {

    private IZoologieInvertebresAutresService zoologieInvertebresAutresService;

    public ZoologieInvertebresAutresManager() {
        this.zoologieInvertebresAutresService = ServiceGenerator.createService(IZoologieInvertebresAutresService.class);
    }

    public void getAllZoologieInvertebresAutres(final ICallback<List<ZoologieInvertebresAutres>> callback){
        final Call<List<ZoologieInvertebresAutres>> call = zoologieInvertebresAutresService.getAllZoologieInvertebresAutres();
        call.enqueue(new Callback<List<ZoologieInvertebresAutres>>() {
            @Override
            public void onResponse(Call<List<ZoologieInvertebresAutres>> call, Response<List<ZoologieInvertebresAutres>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ZoologieInvertebresAutres>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
