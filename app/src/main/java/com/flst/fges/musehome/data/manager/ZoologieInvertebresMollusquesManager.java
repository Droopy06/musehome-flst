package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.converter.ZoologieInvertebresMollusquesConverter;
import com.flst.fges.musehome.data.model.ZoologieInvertebresMollusques;
import com.flst.fges.musehome.data.service.IZoologieInvertebresMollusquesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieInvertebresMollusquesManager {

    private IZoologieInvertebresMollusquesService zoologieInvertebresMollusquesService;

    public ZoologieInvertebresMollusquesManager() {
        this.zoologieInvertebresMollusquesService = ServiceGenerator.createService(IZoologieInvertebresMollusquesService.class);
    }

    public void getAllZoologieInvertebresMollusques(final ICallback<List<ZoologieInvertebresMollusques>> callback){
        final Call<List<ZoologieInvertebresMollusques>> call = zoologieInvertebresMollusquesService.getAllZoologieInvertebresMollusques();
        call.enqueue(new Callback<List<ZoologieInvertebresMollusques>>() {
            @Override
            public void onResponse(Call<List<ZoologieInvertebresMollusques>> call, Response<List<ZoologieInvertebresMollusques>> response) {
                if(response.isSuccessful() && response.body() != null){
                    ZoologieInvertebresMollusquesConverter zoologieInvertebresMollusquesConverter = new ZoologieInvertebresMollusquesConverter();
                    callback.success(zoologieInvertebresMollusquesConverter.convertDtoToZoologieInvertebresMollusques(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<ZoologieInvertebresMollusques>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
