package com.example.chalauri.giphydownloader;

import com.android.volley.VolleyError;

/**
 * Created by chalauri on 10/13/2016.
 */
public interface ResultListener<T> {
    void onResponse(T result);

    void onError(VolleyError error);
}
