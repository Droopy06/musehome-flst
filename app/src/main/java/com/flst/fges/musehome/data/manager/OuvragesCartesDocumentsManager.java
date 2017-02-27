package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.converter.OuvragesCartesDocumentsConverter;
import com.flst.fges.musehome.data.model.OuvragesCartesDocuments;
import com.flst.fges.musehome.data.service.IOuvragesCartesDocumentsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class OuvragesCartesDocumentsManager {

    private IOuvragesCartesDocumentsService ouvragesCartesDocumentsService;

    public OuvragesCartesDocumentsManager() {
        this.ouvragesCartesDocumentsService = ServiceGenerator.createService(IOuvragesCartesDocumentsService.class);
    }

    public void getAllOuvragesCartesDocuments(final ICallback<List<OuvragesCartesDocuments>> callback){
        final Call<List<OuvragesCartesDocuments>> call = ouvragesCartesDocumentsService.getAllOuvragesCartesDocuments();
        call.enqueue(new Callback<List<OuvragesCartesDocuments>>() {
            @Override
            public void onResponse(Call<List<OuvragesCartesDocuments>> call, Response<List<OuvragesCartesDocuments>> response) {
                if(response.isSuccessful() && response.body() != null){
                    OuvragesCartesDocumentsConverter ouvragesCartesDocumentsConverter = new OuvragesCartesDocumentsConverter();
                    callback.success(ouvragesCartesDocumentsConverter.convertDtoToOuvragesCartesDocuments(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<OuvragesCartesDocuments>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
