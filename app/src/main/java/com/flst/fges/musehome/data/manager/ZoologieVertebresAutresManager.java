package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.ZoologieVertebresAutres;
import com.flst.fges.musehome.data.service.IZoologieVertebresAutresService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresAutresManager {

    private IZoologieVertebresAutresService zoologieVertebresAutresService;

    public ZoologieVertebresAutresManager() {
        this.zoologieVertebresAutresService = ServiceGenerator.createService(IZoologieVertebresAutresService.class);
    }

    public void getAllZoologieVertebresAutres(final ICallback<List<ZoologieVertebresAutres>> callback){
        final Call<List<ZoologieVertebresAutres>> call = zoologieVertebresAutresService.getAllZoologieVertebresAutres();
        call.enqueue(new Callback<List<ZoologieVertebresAutres>>() {
            @Override
            public void onResponse(Call<List<ZoologieVertebresAutres>> call, Response<List<ZoologieVertebresAutres>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ZoologieVertebresAutres>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
