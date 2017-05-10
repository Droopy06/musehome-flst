package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.Evenement;
import com.flst.fges.musehome.data.service.IEvenementService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class EvenementsManager {

    private IEvenementService evenementService;

    public EvenementsManager() {
        this.evenementService = ServiceGenerator.createService(IEvenementService.class);
    }

    public void getAllEvenements(final ICallback<List<Evenement>> callback){
        final Call<List<Evenement>> call = evenementService.getAllEvenements();
        call.enqueue(new Callback<List<Evenement>>() {
            @Override
            public void onResponse(Call<List<Evenement>> call, Response<List<Evenement>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Evenement>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }

    public void getEvenementByTitle(String title,final ICallback<Evenement> callback){
        final Call<Evenement> call = evenementService.getEvenementsByTitle(title);
        call.enqueue(new Callback<Evenement>() {
            @Override
            public void onResponse(Call<Evenement> call, Response<Evenement> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<Evenement> call, Throwable t) {
                callback.failure(t);
            }
        });
    }

    public void getEvenementByPosition(String number,final ICallback<Evenement> callback){
        final Call<Evenement> call = evenementService.getEvenementsByPosition(number);
        call.enqueue(new Callback<Evenement>() {
            @Override
            public void onResponse(Call<Evenement> call, Response<Evenement> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<Evenement> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
