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
import com.flst.fges.musehome.data.helper.UrlHelper;
import com.flst.fges.musehome.data.model.DefaultClassCollection;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class    DefaultClassCollectionAdapater<T extends DefaultClassCollection> extends RecyclerView.Adapter<DefaultClassCollectionAdapater.ViewHolder>  {

    private List<T> defaultClassCollections;
    private Context context;

    public DefaultClassCollectionAdapater(List<T> defaultClassCollections, Context context) {
        this.defaultClassCollections = defaultClassCollections;
        this.context = context;
    }

    @Override
    public DefaultClassCollectionAdapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View wodView = inflater.inflate(R.layout.collections_cardview,parent,false);
        return new ViewHolder(wodView);
    }

    //update, change list, notify

    @Override
    public void onBindViewHolder(DefaultClassCollectionAdapater.ViewHolder holder, int position) {
        holder.objectCollectionTxt.setText(defaultClassCollections.get(position).getId()+" "+defaultClassCollections.get(position).getName());
        Picasso.with(context)
                .load("http://"+ UrlHelper.BASE_URL_API+"/patrimoine/images/Collections/materielpedagogique/"+defaultClassCollections.get(position).getPicture())
                .placeholder(R.drawable.banniere)
                .into(holder.objectCollectionImagageView);
    }

    @Override
    public int getItemCount() {
        return defaultClassCollections.size();
    }

    public DefaultClassCollection getItemAtPosition(int position) {
        return defaultClassCollections.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.collections_text_card)
        TextView objectCollectionTxt;
        @BindView(R.id.collections_imageview)
        ImageView objectCollectionImagageView;
        @BindView(R.id.collections_cardview)
        CardView objectcollectionCardView;

        @OnClick(R.id.collections_cardview)
        public void onClick(View v) {
            Snackbar snackbar = Snackbar
                    .make(v, objectCollectionTxt.getText(), Snackbar.LENGTH_LONG);
            snackbar.show();
            /*Intent intent = new Intent(itemView.getContext(), ObjetsDetailActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("OBJET",objectCollectionTxt.getText().toString());
            intent.putExtra("COLLECTION","Materiel Pedagogique");
            itemView.getContext().startActivity(intent);*/
        }

        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
