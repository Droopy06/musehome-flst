package com.flst.fges.musehome.data.manager;

import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.ServiceGenerator;
import com.flst.fges.musehome.data.model.JardinBotanique;
import com.flst.fges.musehome.data.service.IJardinBotaniqueService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class JardinBotaniqueManager {

    private IJardinBotaniqueService jardinBotaniqueService;

    public JardinBotaniqueManager() {
        this.jardinBotaniqueService = ServiceGenerator.createService(IJardinBotaniqueService.class);
    }

    public void getAllJardinBotanique(final ICallback<List<JardinBotanique>> callback){
        final Call<List<JardinBotanique>> call = jardinBotaniqueService.getAllJardinBotanique();
        call.enqueue(new Callback<List<JardinBotanique>>() {
            @Override
            public void onResponse(Call<List<JardinBotanique>> call, Response<List<JardinBotanique>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<JardinBotanique>> call, Throwable t) {
                callback.failure(t);
            }
        });
    }
}
