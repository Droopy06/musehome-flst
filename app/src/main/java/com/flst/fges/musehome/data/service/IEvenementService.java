package com.flst.fges.musehome.data.service;

import com.flst.fges.musehome.data.model.Evenement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public interface IEvenementService {

    @GET("evenements")
    Call<List<Evenement>> getAllEvenements();
    @GET("evenement/{title}")
    Call<Evenement> getEvenementsByTitle(@Path("title") String title);
    @GET("evenement/position/{number}")
    Call<Evenement> getEvenementsByPosition(@Path("number") String number);
}
