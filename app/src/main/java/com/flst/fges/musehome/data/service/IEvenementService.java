package com.flst.fges.musehome.data.service;

import com.flst.fges.musehome.data.dto.EvenementDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public interface IEvenementService {

    @GET("evenements")
    Call<List<EvenementDTO>> getAllEvenements();
    @GET("evenement/{title}")
    Call<EvenementDTO> getEvenementsByTitle(@Path("title") String title);
    @GET("evenement/position/{number}")
    Call<EvenementDTO> getEvenementsByPosition(@Path("number") String number);
}
