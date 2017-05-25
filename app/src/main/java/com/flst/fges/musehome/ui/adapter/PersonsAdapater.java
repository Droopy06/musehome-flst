package com.flst.fges.musehome.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.model.Persons;
import com.flst.fges.musehome.ui.helper.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class PersonsAdapater extends RecyclerView.Adapter<PersonsAdapater.ViewHolder> {

    private List<Persons> personses;
    private Context context;

    public PersonsAdapater(List<Persons> personses, Context context) {
        this.personses = personses;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View wodView = inflater.inflate(R.layout.person_list, parent, false);
        return new ViewHolder(wodView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.personTxt.setText(personses.get(position).getName()+" "+personses.get(position).getLastName());
        holder.mailTxt.setText(personses.get(position).getMail());
        Picasso.with(context).load(personses.get(position).getImg())
                .placeholder(R.drawable.loading)
                .transform(new CircleTransform())
                //.resize(50,50)
                .error(R.drawable.image_download_error_24dp)
                .into(holder.personImagageView);
    }

    @Override
    public int getItemCount() {
        return personses.size();
    }

    public Persons getItemAtPosition(int position) {
        return personses.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.person_titre_list_textView)
        TextView personTxt;
        @BindView(R.id.person_mail_list_textview)
        TextView mailTxt;
        @BindView(R.id.person_list_imageView)
        ImageView personImagageView;

        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
