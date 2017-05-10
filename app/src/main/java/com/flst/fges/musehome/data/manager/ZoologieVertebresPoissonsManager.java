package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.ZoologieVertebresPoissons;
import com.flst.fges.musehome.data.service.IZoologieVertebresPoissonsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresPoissonsManager {

    private IZoologieVertebresPoissonsService zoologieVertebresPoissonsService;

    public ZoologieVertebresPoissonsManager() {
        this.zoologieVertebresPoissonsService = ServiceGenerator.createService(IZoologieVertebresPoissonsService.class);
    }

    public void getAllZoologieVertebresPoissons(final ICallback<List<ZoologieVertebresPoissons>> callback){
        final Call<List<ZoologieVertebresPoissons>> call = zoologieVertebresPoissonsService.getAllZoologieVertebresPoissons();
        call.enqueue(new Callback<List<ZoologieVertebresPoissons>>() {
            @Override
            public void onResponse(Call<List<ZoologieVertebresPoissons>> call, Response<List<ZoologieVertebresPoissons>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ZoologieVertebresPoissons>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
