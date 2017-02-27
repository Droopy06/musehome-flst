package com.flst.fges.musehome.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.model.PaleontologieAnimale;
import com.flst.fges.musehome.ui.activity.ObjetsDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class PaleontologieAnimaleAdapater extends RecyclerView.Adapter<PaleontologieAnimaleAdapater.ViewHolder>  {

    private ArrayList<PaleontologieAnimale> paleontologieAnimales;
    private Context context;

    public PaleontologieAnimaleAdapater(ArrayList<PaleontologieAnimale> paleontologieAnimales, Context context) {
        this.paleontologieAnimales = paleontologieAnimales;
        this.context = context;
    }

    @Override
    public PaleontologieAnimaleAdapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View wodView = inflater.inflate(R.layout.collections_cardview,parent,false);
        return new ViewHolder(wodView);
    }

    @Override
    public void onBindViewHolder(PaleontologieAnimaleAdapater.ViewHolder holder, int position) {
        holder.objectCollectionTxt.setText(paleontologieAnimales.get(position).getName());
        Picasso.with(context).load(paleontologieAnimales.get(position).getPicture()).into(holder.objectCollectionImagageView);
    }

    @Override
    public int getItemCount() {
        return paleontologieAnimales.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView objectCollectionTxt;
        ImageView objectCollectionImagageView;
        CardView objectcollectionCardView;

        ViewHolder(final View itemView) {
            super(itemView);
            objectCollectionTxt = (TextView) itemView.findViewById(R.id.collections_text_card);
            objectCollectionImagageView = (ImageView) itemView.findViewById(R.id.collections_imageview);
            objectcollectionCardView = (CardView) itemView.findViewById(R.id.collections_cardview);
            objectcollectionCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar snackbar = Snackbar
                            .make(v, objectCollectionTxt.getText(), Snackbar.LENGTH_LONG);
                    snackbar.show();
                    Intent intent = new Intent(itemView.getContext(), ObjetsDetailActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("OBJET",objectCollectionTxt.getText().toString());
                    intent.putExtra("COLLECTION","Paleontologie Animale");
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}