package com.flst.fges.musehome.data.service;

import com.flst.fges.musehome.data.model.CollectionDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public interface ICollectionsDetailsService {

    @GET("collectionsdetails/")
    Call<List<CollectionDetails>> getAllCollectionsDetails();

    @GET("collectionsdetails/{collection}")
    Call<CollectionDetails> getCollectionsDetailByName(@Path("collection") String collection);
}
