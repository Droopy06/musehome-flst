package com.flst.fges.musehome.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flst.fges.musehome.R;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LAMOOT Alexandre on 25/05/2017.
 */

public class ObjetsDetailAdapter extends RecyclerView.Adapter<ObjetsDetailAdapter.Holder> {

    private Map<String,String> informations;

    public ObjetsDetailAdapter(Map<String, String> informations) {
        this.informations = informations/*new TreeMap<String,String>(informations)*/;
    }

    static class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.object_header_textview)
        TextView headerTextView;
        @BindView(R.id.object_title_textview)
        TextView textView;

        Holder(View itemView) {
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
        informations = new TreeMap<>(informations);
        String key = (String) informations.keySet().toArray()[position];
        holder.textView.setText(informations.get(key));
        holder.headerTextView.setText(key);
    }

    @Override
    public int getItemCount() {
        return informations.size();
    }
}
