package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.ZoologieVertebresPrimates;
import com.flst.fges.musehome.data.service.IZoologieVertebresPrimatesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresPrimatesManager {

    private IZoologieVertebresPrimatesService zoologieVertebresPrimatesService;

    public ZoologieVertebresPrimatesManager() {
        this.zoologieVertebresPrimatesService = ServiceGenerator.createService(IZoologieVertebresPrimatesService.class);
    }

    public void getAllZoologieVertebresPrimates(final ICallback<List<ZoologieVertebresPrimates>> callback){
        final Call<List<ZoologieVertebresPrimates>> call = zoologieVertebresPrimatesService.getAllZoologieVertebresPrimates();
        call.enqueue(new Callback<List<ZoologieVertebresPrimates>>() {
            @Override
            public void onResponse(Call<List<ZoologieVertebresPrimates>> call, Response<List<ZoologieVertebresPrimates>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ZoologieVertebresPrimates>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
