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
import com.flst.fges.musehome.data.model.Evenement;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class EvenementsAdapater extends RecyclerView.Adapter<EvenementsAdapater.ViewHolder> {

    private List<Evenement> evenements;
    private Context context;

    public EvenementsAdapater(List<Evenement> evenements, Context context) {
        this.evenements = evenements;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View wodView = inflater.inflate(R.layout.evenements_cardview, parent, false);
        return new ViewHolder(wodView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.evenementTxt.setText(evenements.get(position).getTitre());
        Picasso.with(context).load(evenements.get(position).getImageuri()).into(holder.evnementImagageView);
    }

    @Override
    public int getItemCount() {
        return evenements.size();
    }



    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.evenement_text_card)
        TextView evenementTxt;
        @BindView(R.id.evenement_imageview)
        ImageView evnementImagageView;
        @BindView(R.id.evenements_cardview)
        CardView evenementCardView;

        @OnClick(R.id.evenements_cardview)
        public void onClick(View v) {
            Snackbar snackbar = Snackbar
                    .make(v, evenementTxt.getText(), Snackbar.LENGTH_LONG);
            snackbar.show();
            /*Intent intent = new Intent(itemView.getContext(), EvenementDetailActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("EVENEMENT",evenementTxt.getText().toString());
            itemView.getContext().startActivity(intent);*/
        }

        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
