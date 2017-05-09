package com.flst.fges.musehome.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.helper.SizeOfObjectsCollectionHelper;
import com.flst.fges.musehome.data.model.Collection;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class CollectionsAdapater extends RecyclerView.Adapter<CollectionsAdapater.ViewHolder>  {

    private List<Collection> collections;
    private Context context;

    public CollectionsAdapater(List<Collection> collections, Context context) {
        this.collections = collections;
        this.context = context;
    }

    @Override
    public CollectionsAdapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View wodView = inflater.inflate(R.layout.collections_list,parent,false);
        return new ViewHolder(wodView);
    }

    @Override
    public void onBindViewHolder(CollectionsAdapater.ViewHolder holder, int position) {
        holder.collectionsTxt.setText(collections.get(position).getNom());
        holder.numberCollectionsTxt.setText(String.valueOf(new SizeOfObjectsCollectionHelper(this.context).getSizeOfObjectsCollection(collections.get(position).getNom())));
        Picasso.with(context).load(collections.get(position).getImg())
                .placeholder(R.drawable.loading)
                .error(R.drawable.image_download_error_24dp)
                .into(holder.collectionsImagageView);
    }

    @Override
    public int getItemCount() {
        return collections.size();
    }

    public Collection getItemAtPosition(int position) {
        return collections.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.collection_name_list_textView)
        TextView collectionsTxt;
        @BindView(R.id.nombre_collections_list_textView)
        TextView numberCollectionsTxt;
        @BindView(R.id.collections_list_imageView)
        ImageView collectionsImagageView;

        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
