package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.MineralogieCristallographie;
import com.flst.fges.musehome.data.service.IMineralogieCristallographieService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class MineralogieCristallographieManager {

    private IMineralogieCristallographieService cristallographieService;

    public MineralogieCristallographieManager() {
        this.cristallographieService = ServiceGenerator.createService(IMineralogieCristallographieService.class);
    }

    public void getAllMineralogieCristallographie(final ICallback<List<MineralogieCristallographie>> callback){
        final Call<List<MineralogieCristallographie>> call = cristallographieService.getAllMineralogieCristallographie();
        call.enqueue(new Callback<List<MineralogieCristallographie>>() {
            @Override
            public void onResponse(Call<List<MineralogieCristallographie>> call, Response<List<MineralogieCristallographie>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<MineralogieCristallographie>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
