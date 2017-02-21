package com.flst.fges.musehome.data.service;

import com.flst.fges.musehome.data.model.ZoologieVertebresAutres;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public interface IZoologieVertebresAutresService {

    @GET("zoologievertebresautres")
    Call<List<ZoologieVertebresAutres>> getAllZoologieVertebresAutres();
}
