package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.ZoologieVertebresOiseaux;
import com.flst.fges.musehome.data.service.IZoologieVertebresOiseauxService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresOiseauxManager {

    private IZoologieVertebresOiseauxService zoologieVertebresOiseauxService;

    public ZoologieVertebresOiseauxManager() {
        this.zoologieVertebresOiseauxService = ServiceGenerator.createService(IZoologieVertebresOiseauxService.class);
    }

    public void getAllZoologieVertebresOiseaux(final ICallback<List<ZoologieVertebresOiseaux>> callback){
        final Call<List<ZoologieVertebresOiseaux>> call = zoologieVertebresOiseauxService.getAllZoologieVertebresOiseaux();
        call.enqueue(new Callback<List<ZoologieVertebresOiseaux>>() {
            @Override
            public void onResponse(Call<List<ZoologieVertebresOiseaux>> call, Response<List<ZoologieVertebresOiseaux>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ZoologieVertebresOiseaux>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
