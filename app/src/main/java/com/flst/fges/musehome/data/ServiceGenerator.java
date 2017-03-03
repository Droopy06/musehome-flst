package com.flst.fges.musehome.data;

import com.flst.fges.musehome.data.helper.UrlHelper;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Quentin on 23/02/2016.
 */
public final class ServiceGenerator {

    private static Retrofit sRetrofit;

    private ServiceGenerator(){
    }

    private static Retrofit getRetrofit() {
        if (sRetrofit == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY));

            sRetrofit = new Retrofit.Builder()
                    .baseUrl("http://"+UrlHelper.BASE_URL_API+"/patrimoine/rest/patrimoine/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return sRetrofit;
    }

    public static <S> S createService(Class<S> serviceClass) {
        return getRetrofit().create(serviceClass);
    }
}
