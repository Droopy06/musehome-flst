package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.ZoologieVertebresReptile;
import com.flst.fges.musehome.data.service.IZoologieVertebresReptileService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresReptileManager {

    private IZoologieVertebresReptileService zoologieVertebresReptileService;

    public ZoologieVertebresReptileManager() {
        this.zoologieVertebresReptileService = ServiceGenerator.createService(IZoologieVertebresReptileService.class);
    }

    public void getAllZoologieVertebresReptile(final ICallback<List<ZoologieVertebresReptile>> callback){
        final Call<List<ZoologieVertebresReptile>> call = zoologieVertebresReptileService.getAllZoologieVertebresReptile();
        call.enqueue(new Callback<List<ZoologieVertebresReptile>>() {
            @Override
            public void onResponse(Call<List<ZoologieVertebresReptile>> call, Response<List<ZoologieVertebresReptile>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ZoologieVertebresReptile>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
