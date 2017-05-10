package com.flst.fges.musehome.data.service;

import com.flst.fges.musehome.data.model.Contact;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by LAMOOT Alexandre on 13/04/2017.
 */

public interface IContactService {
    @POST("contact/save")
    Call<Contact> saveContact(@Body Contact contact);
}
