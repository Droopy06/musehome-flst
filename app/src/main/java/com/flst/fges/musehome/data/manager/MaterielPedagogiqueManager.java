package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.converter.MaterielPedagogiqueConverter;
import com.flst.fges.musehome.data.model.MaterielPedagogique;
import com.flst.fges.musehome.data.service.IMaterielPedagogiqueService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class MaterielPedagogiqueManager {

    private IMaterielPedagogiqueService materielPedagogiqueService;

    public MaterielPedagogiqueManager() {
        this.materielPedagogiqueService = ServiceGenerator.createService(IMaterielPedagogiqueService.class);
    }

    public void getAllMaterielPedagogique(final ICallback<List<MaterielPedagogique>> callback){
        final Call<List<MaterielPedagogique>> call = materielPedagogiqueService.getAllMaterielPedagogique();
        call.enqueue(new Callback<List<MaterielPedagogique>>() {
            @Override
            public void onResponse(Call<List<MaterielPedagogique>> call, Response<List<MaterielPedagogique>> response) {
                if(response.isSuccessful() && response.body() != null){
                    MaterielPedagogiqueConverter materielPedagogiqueConverter = new MaterielPedagogiqueConverter();
                    callback.success(materielPedagogiqueConverter.convertDtoToMaterielPedagogique(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<MaterielPedagogique>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }

    public void getMaterielPedagogiqueByName(String object,final ICallback<MaterielPedagogique> callback){
        final Call<MaterielPedagogique> call = materielPedagogiqueService.getMaterielPedagogiqueByName(object);
        call.enqueue(new Callback<MaterielPedagogique>() {
            @Override
            public void onResponse(Call<MaterielPedagogique> call, Response<MaterielPedagogique> response) {
                if(response.isSuccessful() && response.body() != null){
                    MaterielPedagogiqueConverter materielPedagogiqueConverter = new MaterielPedagogiqueConverter();
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<MaterielPedagogique> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
