package com.flst.fges.musehome.ui.vewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.model.Persons;
import com.flst.fges.musehome.ui.helper.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * Created by LAMOOT Alexandre on 25/05/2017.
 */

public class PersonsSection extends StatelessSection {

    private String category;
    private List<Persons> list;
    private Context context;

    public PersonsSection(Context context,String category, List<Persons> list){
        super(R.layout.person_header,R.layout.person_list);
        this.category = category;
        this.list = list;
        this.context = context;
    }

    @Override
    public int getContentItemsTotal() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new PersonItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        final PersonItemViewHolder itemHolder = (PersonItemViewHolder) holder;
        itemHolder.personTxt.setText(list.get(position).getName()+" "+list.get(position).getLastName());
        itemHolder.mailTxt.setText(list.get(position).getMail());
        Picasso.with(context).load(list.get(position).getImg())
                .placeholder(R.drawable.loading)
                .transform(new CircleTransform())
                //.resize(50,50)
                .error(R.drawable.image_download_error_24dp)
                .into(itemHolder.personImagageView);
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new PersonHeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        PersonHeaderViewHolder headerHolder = (PersonHeaderViewHolder) holder;
        headerHolder.personCategory.setText(category);
    }
}
