package com.flst.fges.musehome.data.manager;

import android.util.Log;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.Contact;
import com.flst.fges.musehome.data.service.IContactService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by LAMOOT Alexandre on 13/04/2017.
 */

public class ContactManager {

    private IContactService collectionsService;

    public ContactManager() {
        this.collectionsService = ServiceGenerator.createService(IContactService.class);
    }

    public void saveContact(Contact contact,final ICallback<Contact> callback){
        final Call<Contact> call = collectionsService.saveContact(contact);
        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                int statusCode = response.code();
                Log.i(TAG, "Status Code: " + statusCode);
                if(response.isSuccessful() && response.body()!= null) {
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
