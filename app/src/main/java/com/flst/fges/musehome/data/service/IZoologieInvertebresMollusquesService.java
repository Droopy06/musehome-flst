package com.flst.fges.musehome.data.service;

import com.flst.fges.musehome.data.model.ZoologieInvertebresMollusques;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public interface IZoologieInvertebresMollusquesService {

    @GET("zoologieinvertebresmollusques")
    Call<List<ZoologieInvertebresMollusques>> getAllZoologieInvertebresMollusques();
}

