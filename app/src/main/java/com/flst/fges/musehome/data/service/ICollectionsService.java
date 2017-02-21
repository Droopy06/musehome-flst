package com.flst.fges.musehome.data.service;

import com.flst.fges.musehome.data.dto.CollectionDTO;
import com.flst.fges.musehome.data.model.Collection;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public interface ICollectionsService {

    @GET("collections")
    Call<List<CollectionDTO>> getAllCollections();
}
