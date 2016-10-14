package com.example.chalauri.giphydownloader;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by chalauri on 10/13/2016.
 */
public class BaseRequest {
    public static final String TAG = BaseRequest.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private static BaseRequest mInstance;
    private Context ctx;

    public BaseRequest(Context ctx) {
        this.ctx = ctx;
        mInstance = this;

        //CookieManager cookieManager = new CookieManager();
        //CookieHandler.setDefault(cookieManager);

        mRequestQueue = Volley.newRequestQueue(this.ctx);
    }

    public static synchronized BaseRequest getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {

        if (mRequestQueue == null) {
            return Volley.newRequestQueue(this.ctx);
        }

        return mRequestQueue;
    }

    public <T> void add(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public <T> void add(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancel() {
        mRequestQueue.cancelAll(TAG);
    }

    public void cancel(String tag) {
        mRequestQueue.cancelAll(tag);
    }
}
