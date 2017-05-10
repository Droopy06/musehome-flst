package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.Petrographie;
import com.flst.fges.musehome.data.service.IPetrographieService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class PetrographieManager {

    private IPetrographieService petrographieService;

    public PetrographieManager() {
        this.petrographieService = ServiceGenerator.createService(IPetrographieService.class);
    }

    public void getAllPetrographie(final ICallback<List<Petrographie>> callback){
        final Call<List<Petrographie>> call = petrographieService.getAllPetrographie();
        call.enqueue(new Callback<List<Petrographie>>() {
            @Override
            public void onResponse(Call<List<Petrographie>> call, Response<List<Petrographie>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Petrographie>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
