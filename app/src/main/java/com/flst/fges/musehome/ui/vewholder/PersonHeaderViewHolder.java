package com.flst.fges.musehome.ui.vewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.flst.fges.musehome.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LAMOOT Alexandre on 25/05/2017.
 */

public class PersonHeaderViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.title_person_textview)
    public TextView personCategory;

    public PersonHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
