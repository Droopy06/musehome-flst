package com.flst.fges.musehome.ui.vewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flst.fges.musehome.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LAMOOT Alexandre on 25/05/2017.
 */

public class PersonItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.person_titre_list_textView)
    public TextView personTxt;
    @BindView(R.id.person_mail_list_textview)
    public TextView mailTxt;
    @BindView(R.id.person_list_imageView)
    public ImageView personImagageView;

    public PersonItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
