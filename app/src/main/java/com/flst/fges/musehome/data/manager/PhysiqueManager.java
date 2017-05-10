package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.Physique;
import com.flst.fges.musehome.data.service.IPhysiqueService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class PhysiqueManager {

    private IPhysiqueService physiqueService;

    public PhysiqueManager() {
        this.physiqueService = ServiceGenerator.createService(IPhysiqueService.class);
    }

    public void getAllPhysique(final ICallback<List<Physique>> callback){
        final Call<List<Physique>> call = physiqueService.getAllPhysique();
        call.enqueue(new Callback<List<Physique>>() {
            @Override
            public void onResponse(Call<List<Physique>> call, Response<List<Physique>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Physique>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
