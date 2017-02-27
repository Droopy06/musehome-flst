package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.converter.HerbiersConverter;
import com.flst.fges.musehome.data.model.Herbiers;
import com.flst.fges.musehome.data.service.IHerbiersService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class HerbiersManager {

    private IHerbiersService herbiersService;

    public HerbiersManager() {
        this.herbiersService = ServiceGenerator.createService(IHerbiersService.class);
    }

    public void getAllHerbiers(final ICallback<List<Herbiers>> callback){
        final Call<List<Herbiers>> call = herbiersService.getAllHerbiers();
        call.enqueue(new Callback<List<Herbiers>>() {
            @Override
            public void onResponse(Call<List<Herbiers>> call, Response<List<Herbiers>> response) {
                if(response.isSuccessful() && response.body() != null){
                    HerbiersConverter herbiersConverter = new HerbiersConverter();
                    callback.success(herbiersConverter.convertDtoToHerbiers(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Herbiers>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
