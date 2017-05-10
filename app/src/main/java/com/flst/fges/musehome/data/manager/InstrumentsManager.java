package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.Instruments;
import com.flst.fges.musehome.data.service.IInstrumentsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class InstrumentsManager {

    private IInstrumentsService instrumentsService;

    public InstrumentsManager() {
        this.instrumentsService = ServiceGenerator.createService(IInstrumentsService.class);
    }

    public void getAllInstruments(final ICallback<List<Instruments>> callback){
        final Call<List<Instruments>> call = instrumentsService.getAllInstruments();
        call.enqueue(new Callback<List<Instruments>>() {
            @Override
            public void onResponse(Call<List<Instruments>> call, Response<List<Instruments>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Instruments>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
