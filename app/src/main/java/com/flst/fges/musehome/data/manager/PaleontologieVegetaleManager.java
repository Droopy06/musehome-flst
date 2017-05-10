package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.PaleontologieVegetale;
import com.flst.fges.musehome.data.service.IPaleontologieVegetaleService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class PaleontologieVegetaleManager {

    private IPaleontologieVegetaleService paleontologieVegetaleService;

    public PaleontologieVegetaleManager() {
        this.paleontologieVegetaleService = ServiceGenerator.createService(IPaleontologieVegetaleService.class);
    }

    public void getAllPaleontologieVegetale(final ICallback<List<PaleontologieVegetale>> callback){
        final Call<List<PaleontologieVegetale>> call = paleontologieVegetaleService.getAllPaleontologieVegetale();
        call.enqueue(new Callback<List<PaleontologieVegetale>>() {
            @Override
            public void onResponse(Call<List<PaleontologieVegetale>> call, Response<List<PaleontologieVegetale>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PaleontologieVegetale>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
