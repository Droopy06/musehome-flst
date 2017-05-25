package com.flst.fges.musehome.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flst.fges.musehome.R;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LAMOOT Alexandre on 25/05/2017.
 */

public class ObjetsDetailAdapter extends RecyclerView.Adapter<ObjetsDetailAdapter.Holder> {

    HashMap<String,String> informations;
    ArrayList<String> keyHeaderMap;

    public ObjetsDetailAdapter(HashMap<String, String> informations,ArrayList<String> keyHeaderMap) {
        this.informations = informations;
        this.keyHeaderMap = keyHeaderMap;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.object_header_textview)
        public TextView headerTextView;
        @BindView(R.id.object_title_textview)
        public TextView textView;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.objets_details, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String key = (String) informations.keySet().toArray()[position];
        holder.textView.setText(key);
        holder.headerTextView.setText(informations.get(key));
    }

    @Override
    public int getItemCount() {
        return informations.size();
    }
}
