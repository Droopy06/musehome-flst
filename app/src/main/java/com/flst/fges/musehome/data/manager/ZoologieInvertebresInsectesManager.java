package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.ZoologieInvertebresInsectes;
import com.flst.fges.musehome.data.service.IZoologieInvertebresInsectesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieInvertebresInsectesManager {

    private IZoologieInvertebresInsectesService zoologieInvertebresInsectesService;

    public ZoologieInvertebresInsectesManager() {
        this.zoologieInvertebresInsectesService = ServiceGenerator.createService(IZoologieInvertebresInsectesService.class);
    }

    public void getAllZoologieInvertebresInsectes(final ICallback<List<ZoologieInvertebresInsectes>> callback){
        final Call<List<ZoologieInvertebresInsectes>> call = zoologieInvertebresInsectesService.getAllZoologieInvertebresInsectes();
        call.enqueue(new Callback<List<ZoologieInvertebresInsectes>>() {
            @Override
            public void onResponse(Call<List<ZoologieInvertebresInsectes>> call, Response<List<ZoologieInvertebresInsectes>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ZoologieInvertebresInsectes>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
