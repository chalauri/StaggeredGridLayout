package com.example.chalauri.giphydownloader;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setVisibility(View.INVISIBLE);


                //-----------
                Ion.with(getApplicationContext())
                        .load("http://api.giphy.com/v1/stickers/trending?api_key=dc6zaTOxFJmzC")
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                Log.i("DATA", result.toString());
                                Type listType = new TypeToken<List<GiphyModel>>() {
                                }.getType();
                                Log.i("DATA", result.get("data").toString());
                                List<GiphyModel> data = new Gson().fromJson(result.get("data"), listType);

                                GiphyModel one = data.get(10);

                                // Ion.with(imageView)
                                //         .load(one.images.original.url);

                                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                                recyclerView.setHasFixedSize(true);

                                staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
                                recyclerView.setLayoutManager(staggeredGridLayoutManager);

                                List<GiphyModel> gaggeredList = data;

                                SolventRecyclerViewAdapter rcAdapter = new SolventRecyclerViewAdapter(MainActivity.this, gaggeredList);
                                recyclerView.setAdapter(rcAdapter);
                            }
                        });
                //--------
            }
        });


    }
}
