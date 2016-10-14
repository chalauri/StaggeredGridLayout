package com.example.chalauri.giphydownloader;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chalauri on 10/13/2016.
 */
public class CustomJsonObjectRequest extends JsonObjectRequest {
    private Priority mPriority;
    private Map<String, String> headers = new HashMap<>();

    public CustomJsonObjectRequest(int method, String url, JSONObject jsonRequest,
                                   Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public CustomJsonObjectRequest(int method, String url, JSONObject jsonRequest,
                                   Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, boolean saveHeaders) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public CustomJsonObjectRequest(int method, String url,
                                   Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public CustomJsonObjectRequest(int method, String url,
                                   Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, boolean saveHeaders) {
        super(method, url, listener, errorListener);
    }

    public void setPriority(Priority priority) {
        mPriority = priority;
    }

    public void setCookies(List<String> cookies) {
        StringBuilder sb = new StringBuilder();
        for (String cookie : cookies) {
            sb.append(cookie).append("; ");
        }
        headers.put("Cookie", sb.toString());
    }


    @Override
    public Priority getPriority() {
        return mPriority == null ? Priority.NORMAL : mPriority;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers;
    }

}
