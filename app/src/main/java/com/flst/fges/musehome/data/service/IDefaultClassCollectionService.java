package com.flst.fges.musehome.data.service;

import com.flst.fges.musehome.data.model.DefaultClassCollection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public interface IDefaultClassCollectionService {

    @GET("{collection}/{object}")
    Call<DefaultClassCollection> getObjectCollectionByName(@Path("collection") String collection,
                                                           @Path("object") String object);
}
