package com.flst.fges.musehome.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.model.DefaultClassCollection;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class DefaultClassCollectionAdapater extends RecyclerView.Adapter<DefaultClassCollectionAdapater.ViewHolder>  {

    private List<DefaultClassCollection> defaultClassCollections;
    private Context context;

    public DefaultClassCollectionAdapater(List<DefaultClassCollection> defaultClassCollections, Context context) {
        this.defaultClassCollections = defaultClassCollections;
        this.context = context;
    }

    @Override
    public DefaultClassCollectionAdapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View wodView = inflater.inflate(R.layout.collections_cardview,parent,false);
        return new ViewHolder(wodView);
    }

    @Override
    public void onBindViewHolder(DefaultClassCollectionAdapater.ViewHolder holder, int position) {
        holder.objectCollectionTxt.setText(defaultClassCollections.get(position).getName());
        Picasso.with(context).load(defaultClassCollections.get(position).getPicture()).into(holder.objectCollectionImagageView);
    }

    @Override
    public int getItemCount() {
        return defaultClassCollections.size();
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
        }
    }
}
