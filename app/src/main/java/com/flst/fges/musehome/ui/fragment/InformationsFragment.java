package com.flst.fges.musehome.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flst.fges.musehome.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InformationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformationsFragment extends Fragment {

    public InformationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment InformationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InformationsFragment newInstance() {
        InformationsFragment fragment = new InformationsFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informations, container, false);
        return view;
    }

}
