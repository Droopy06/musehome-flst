package com.flst.fges.musehome.data;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */
public interface ICallback<T> {

    void success(T t);

    void failure(Throwable error);
}
