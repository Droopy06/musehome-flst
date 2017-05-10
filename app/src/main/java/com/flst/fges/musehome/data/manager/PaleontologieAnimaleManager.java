package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.PaleontologieAnimale;
import com.flst.fges.musehome.data.service.IPaleontologieAnimaleService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class PaleontologieAnimaleManager {

    private IPaleontologieAnimaleService paleontologieAnimaleService;

    public PaleontologieAnimaleManager() {
        this.paleontologieAnimaleService = ServiceGenerator.createService(IPaleontologieAnimaleService.class);
    }

    public void getAllPaleontologieAnimale(final ICallback<List<PaleontologieAnimale>> callback){
        final Call<List<PaleontologieAnimale>> call = paleontologieAnimaleService.getAllPaleontologieAnimale();
        call.enqueue(new Callback<List<PaleontologieAnimale>>() {
            @Override
            public void onResponse(Call<List<PaleontologieAnimale>> call, Response<List<PaleontologieAnimale>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PaleontologieAnimale>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
