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
import com.flst.fges.musehome.ui.helper.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class EvenementsAdapater extends RecyclerView.Adapter<EvenementsAdapater.ViewHolder> {

    private List<Evenement> evenements;
    private Context context;

    public EvenementsAdapater(List<Evenement> evenements, Context context) {
        this.evenements = evenements;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View wodView = inflater.inflate(R.layout.evenements_list, parent, false);
        return new ViewHolder(wodView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.evenementTxt.setText(evenements.get(position).getTitre());
        if(evenements.get(position).getMiniDescr().length() >= 50)
            holder.descEvenementTxt.setText(evenements.get(position).getMiniDescr().substring(0,50)+"..");
        else
            holder.descEvenementTxt.setText(evenements.get(position).getMiniDescr());
        Picasso.with(context).load(evenements.get(position).getImageuri()).transform(new CircleTransform()).resize(300,300).into(holder.evnementImagageView);
    }

    @Override
    public int getItemCount() {
        return evenements.size();
    }

    public Evenement getItemAtPosition(int position) {
        return evenements.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.evenements_titre_list_textView)
        TextView evenementTxt;
        @BindView(R.id.desc_evenements_list_textView)
        TextView descEvenementTxt;
        @BindView(R.id.evenements_list_imageView)
        ImageView evnementImagageView;

        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
