package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.converter.EvenementsConverter;
import com.flst.fges.musehome.data.dto.EvenementDTO;
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
        final Call<List<EvenementDTO>> call = evenementService.getAllEvenements();
        call.enqueue(new Callback<List<EvenementDTO>>() {
            @Override
            public void onResponse(Call<List<EvenementDTO>> call, Response<List<EvenementDTO>> response) {
                if(response.isSuccessful() && response.body() != null){
                    EvenementsConverter evenementsConverter = new EvenementsConverter();
                    callback.success(evenementsConverter.convertDtoToEvenements(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<EvenementDTO>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }

    public void getEvenementByTitle(String title,final ICallback<Evenement> callback){
        final Call<EvenementDTO> call = evenementService.getEvenementsByTitle(title);
        call.enqueue(new Callback<EvenementDTO>() {
            @Override
            public void onResponse(Call<EvenementDTO> call, Response<EvenementDTO> response) {
                if(response.isSuccessful() && response.body() != null){
                    EvenementsConverter evenementsConverter = new EvenementsConverter();
                    callback.success(evenementsConverter.convertDtoToEvenement(response.body()));
                }
            }

            @Override
            public void onFailure(Call<EvenementDTO> call, Throwable t) {
                callback.failure(t);
            }
        });
    }

    public void getEvenementByPosition(String number,final ICallback<Evenement> callback){
        final Call<EvenementDTO> call = evenementService.getEvenementsByPosition(number);
        call.enqueue(new Callback<EvenementDTO>() {
            @Override
            public void onResponse(Call<EvenementDTO> call, Response<EvenementDTO> response) {
                if(response.isSuccessful() && response.body() != null){
                    EvenementsConverter evenementsConverter = new EvenementsConverter();
                    callback.success(evenementsConverter.convertDtoToEvenement(response.body()));
                }
            }

            @Override
            public void onFailure(Call<EvenementDTO> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
