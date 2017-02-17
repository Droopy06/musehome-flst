package com.flst.fges.musehome.ui.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.model.Collection;
import com.flst.fges.musehome.data.model.MaterielPedagogique;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class MaterielPedagogiqueAdapater extends RecyclerView.Adapter<MaterielPedagogiqueAdapater.ViewHolder>  {

    private ArrayList<MaterielPedagogique> materielPedagogiques;
    private Context context;

    public MaterielPedagogiqueAdapater(ArrayList<MaterielPedagogique> materielPedagogiques, Context context) {
        this.materielPedagogiques = materielPedagogiques;
        this.context = context;
    }

    @Override
    public MaterielPedagogiqueAdapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View wodView = inflater.inflate(R.layout.collections_cardview,parent,false);
        return new ViewHolder(wodView);
    }

    @Override
    public void onBindViewHolder(MaterielPedagogiqueAdapater.ViewHolder holder, int position) {
        holder.collectionsTxt.setText(materielPedagogiques.get(position).getName());
        Picasso.with(context).load(materielPedagogiques.get(position).getPicture()).into(holder.collectionsImagageView);
    }

    @Override
    public int getItemCount() {
        return materielPedagogiques.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView collectionsTxt;
        ImageView collectionsImagageView;
        CardView collectionCardView;

        ViewHolder(View itemView) {
            super(itemView);
            collectionsTxt = (TextView) itemView.findViewById(R.id.collections_text_card);
            collectionsImagageView = (ImageView) itemView.findViewById(R.id.collections_imageview);
            collectionCardView = (CardView) itemView.findViewById(R.id.collections_cardview);
        }
    }
}