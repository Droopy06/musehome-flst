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
import com.flst.fges.musehome.data.helper.UrlHelper;
import com.flst.fges.musehome.data.model.MaterielPedagogique;
import com.flst.fges.musehome.ui.activity.ObjetsDetailActivity;
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
        holder.objectCollectionTxt.setText(materielPedagogiques.get(position).getId()+" "+materielPedagogiques.get(position).getName());
        if(!materielPedagogiques.get(position).getPicture().equals(""))
            Picasso.with(context).load("http://"+ UrlHelper.BASE_URL_API+"/patrimoine/images/Collections/materielpedagogique/"+materielPedagogiques.get(position).getPicture()).into(holder.objectCollectionImagageView);
        else
            Picasso.with(context).load("http://"+ UrlHelper.BASE_URL_API+"/patrimoine/images/icone.png").into(holder.objectCollectionImagageView);
    }

    @Override
    public int getItemCount() {
        return materielPedagogiques.size();
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
                    intent.putExtra("COLLECTION","Materiel Pedagogique");
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
