package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.converter.ZoologieVertebresMammiferesConverter;
import com.flst.fges.musehome.data.model.ZoologieVertebresMammiferes;
import com.flst.fges.musehome.data.service.IZoologieVertebresMammiferesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class ZoologieVertebresMammiferesManager {

    private IZoologieVertebresMammiferesService zoologieVertebresMammiferesService;

    public ZoologieVertebresMammiferesManager() {
        this.zoologieVertebresMammiferesService = ServiceGenerator.createService(IZoologieVertebresMammiferesService.class);
    }

    public void getAllZoologieVertebresMammiferes(final ICallback<List<ZoologieVertebresMammiferes>> callback){
        final Call<List<ZoologieVertebresMammiferes>> call = zoologieVertebresMammiferesService.getAllZoologieVertebresMammiferes();
        call.enqueue(new Callback<List<ZoologieVertebresMammiferes>>() {
            @Override
            public void onResponse(Call<List<ZoologieVertebresMammiferes>> call, Response<List<ZoologieVertebresMammiferes>> response) {
                if(response.isSuccessful() && response.body() != null){
                    ZoologieVertebresMammiferesConverter zoologieVertebresMammiferesConverter = new ZoologieVertebresMammiferesConverter();
                    callback.success(zoologieVertebresMammiferesConverter.convertDtoToZoologieVertebresMammiferes(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<ZoologieVertebresMammiferes>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
