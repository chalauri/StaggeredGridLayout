package com.example.chalauri.giphydownloader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.ion.Ion;

import java.util.List;

/**
 * Created by chalauri on 10/14/2016.
 */

public class SolventRecyclerViewAdapter extends RecyclerView.Adapter<SolventViewHolders> {

    private List<GiphyModel> itemList;
    private Context context;

    public SolventRecyclerViewAdapter(Context context, List<GiphyModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public SolventViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.solvent_list, null);
        SolventViewHolders rcv = new SolventViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(SolventViewHolders holder, int position) {
      //  holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
         Ion.with(holder.countryPhoto)
                .load(itemList.get(position).images.original.url);

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}