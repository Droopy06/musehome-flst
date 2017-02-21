package com.flst.fges.musehome.ui.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.model.Collection;
import com.flst.fges.musehome.data.model.Evenement;
import com.flst.fges.musehome.ui.activity.MainActivity;
import com.flst.fges.musehome.ui.fragment.ObjetsCollectionFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

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
        View wodView = inflater.inflate(R.layout.collections_cardview,parent,false);
        return new ViewHolder(wodView);
    }

    @Override
    public void onBindViewHolder(CollectionsAdapater.ViewHolder holder, int position) {
        holder.collectionsTxt.setText(collections.get(position).getNom());
        Picasso.with(context).load(collections.get(position).getImg()).into(holder.collectionsImagageView);
    }

    @Override
    public int getItemCount() {
        return collections.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView collectionsTxt;
        ImageView collectionsImagageView;
        CardView collectionCardView;

        ViewHolder(final View itemView) {
            super(itemView);
            collectionsTxt = (TextView) itemView.findViewById(R.id.collections_text_card);
            collectionsImagageView = (ImageView) itemView.findViewById(R.id.collections_imageview);
            collectionCardView = (CardView) itemView.findViewById(R.id.collections_cardview);
            collectionCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar snackbar = Snackbar
                            .make(v, collectionsTxt.getText(), Snackbar.LENGTH_LONG);
                    snackbar.show();
                    Fragment frag;
                    frag = ObjetsCollectionFragment.newInstance(collectionsTxt.getText().toString());
                    if (frag != null) {
                        /*FragmentTransaction ft = ((MainActivity) itemView.getContext()).getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.musehome_container, frag, frag.getTag());
                        ft.commit();*/
                    }
                }
            });
        }
    }
}
