package com.flst.fges.musehome.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.factory.EvenementFactory;
import com.flst.fges.musehome.data.manager.EvenementsManager;
import com.flst.fges.musehome.data.model.Evenement;
import com.flst.fges.musehome.ui.adapter.EvenementsAdapater;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EvenementsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EvenementsFragment extends Fragment {


    private EvenementsManager evenementsManager;
    private List<Evenement> evenementList = new ArrayList<>();

    public EvenementsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EvenementsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EvenementsFragment newInstance() {
        EvenementsFragment fragment = new EvenementsFragment();
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
        View view = inflater.inflate(R.layout.fragment_evenements, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.evenements_list);
        final EvenementsAdapater evenementsAdapater = new EvenementsAdapater(evenementList,applicationContext);
        evenementsManager = new EvenementsManager();
        evenementsManager.getAllEvenements(new ICallback<List<Evenement>>() {
            @Override
            public void success(List<Evenement> evenements) {
                evenementList.clear();
                evenementList.addAll(evenements);
                evenementsAdapater.notifyDataSetChanged();
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        recyclerView.setAdapter(evenementsAdapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(applicationContext));
        // Inflate the layout for this fragment
        return view;
    }

}
