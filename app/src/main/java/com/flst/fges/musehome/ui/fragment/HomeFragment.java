package com.flst.fges.musehome.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.factory.EvenementFactory;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class

HomeFragment extends Fragment {

    @BindView(R.id.evenement_imageview)
    ImageView imageView;
    @BindView(R.id.catho_lille_imageview)
    ImageView cathoImageView;
    @BindView(R.id.fges_imageview)
    ImageView fgesImageView;
    @BindView(R.id.text_card)
    TextView textView;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context applicationContext = getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        // Inflate the layout for this fragment
        Picasso.with(applicationContext).load(EvenementFactory.getAllEvenement().get(0).getImageuri()).into(imageView);
        Picasso.with(applicationContext).load(R.drawable.logo_facultes_blanc).fit().into(cathoImageView);
        Picasso.with(applicationContext).load(R.drawable.logo_fges).fit().into(fgesImageView);
        textView.setText(EvenementFactory.getAllEvenement().get(0).getTitre());
        return view;
    }

}
