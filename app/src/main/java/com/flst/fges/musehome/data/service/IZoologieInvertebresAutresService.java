package com.flst.fges.musehome.data.service;

import com.flst.fges.musehome.data.model.ZoologieInvertebresAutres;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public interface IZoologieInvertebresAutresService {

    @GET("zoologieinvertebresautres")
    Call<List<ZoologieInvertebresAutres>> getAllZoologieInvertebresAutres();
}

