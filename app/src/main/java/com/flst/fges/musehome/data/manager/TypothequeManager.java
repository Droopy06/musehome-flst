package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.converter.TypothequeConverter;
import com.flst.fges.musehome.data.model.Typotheque;
import com.flst.fges.musehome.data.service.ITypothequeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class TypothequeManager {

    private ITypothequeService typothequeService;

    public TypothequeManager() {
        this.typothequeService = ServiceGenerator.createService(ITypothequeService.class);
    }

    public void getAllTypotheque(final ICallback<List<Typotheque>> callback){
        final Call<List<Typotheque>> call = typothequeService.getAllTypotheque();
        call.enqueue(new Callback<List<Typotheque>>() {
            @Override
            public void onResponse(Call<List<Typotheque>> call, Response<List<Typotheque>> response) {
                if(response.isSuccessful() && response.body() != null){
                    TypothequeConverter typothequeConverter = new TypothequeConverter();
                    callback.success(typothequeConverter.convertDtoToTypotheque(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Typotheque>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
