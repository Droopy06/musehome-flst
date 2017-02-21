package com.flst.fges.musehome.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.model.Evenement;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class EvenementsAdapater extends RecyclerView.Adapter<EvenementsAdapater.ViewHolder>  {

    private List<Evenement> evenements;
    private Context context;

    public EvenementsAdapater(List<Evenement> evenements, Context context) {
        this.evenements = evenements;
        this.context = context;
    }

    @Override
    public EvenementsAdapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View wodView = inflater.inflate(R.layout.evenements_cardview,parent,false);
        return new ViewHolder(wodView);
    }

    @Override
    public void onBindViewHolder(EvenementsAdapater.ViewHolder holder, int position) {
        holder.evenementTxt.setText(evenements.get(position).getTitre());
        Picasso.with(context).load(evenements.get(position).getImageuri()).into(holder.evnementImagageView);
    }

    @Override
    public int getItemCount() {
        return evenements.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView evenementTxt;
        ImageView evnementImagageView;

        ViewHolder(View itemView) {
            super(itemView);
            evenementTxt = (TextView) itemView.findViewById(R.id.evenement_text_card);
            evnementImagageView = (ImageView) itemView.findViewById(R.id.evenement_imageview);
        }
    }
}
