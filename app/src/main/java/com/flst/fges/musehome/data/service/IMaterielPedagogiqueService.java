package com.flst.fges.musehome.data.service;

import com.flst.fges.musehome.data.model.MaterielPedagogique;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public interface IMaterielPedagogiqueService {

    @GET("materielpedagogique")
    Call<List<MaterielPedagogique>> getAllMaterielPedagogique();
}
