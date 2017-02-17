package com.flst.fges.musehome.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.factory.CollectionFactory;
import com.flst.fges.musehome.data.factory.MaterielPedagogiqueFactory;
import com.flst.fges.musehome.data.model.Collection;
import com.flst.fges.musehome.data.model.MaterielPedagogique;
import com.flst.fges.musehome.ui.adapter.CollectionsAdapater;
import com.flst.fges.musehome.ui.adapter.MaterielPedagogiqueAdapater;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ObjetsCollectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ObjetsCollectionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_COLLECTION = "objet";

    // TODO: Rename and change types of parameters
    private String mParamCollection;


    public ObjetsCollectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param paramCollection Parameter 1.
     * @return A new instance of fragment ObjetsCollectionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ObjetsCollectionFragment newInstance(String paramCollection) {
        ObjetsCollectionFragment fragment = new ObjetsCollectionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_COLLECTION, paramCollection);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamCollection = getArguments().getString(ARG_PARAM_COLLECTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context applicationContext = getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.fragment_objets_collection, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.collections_list);
        ArrayList<MaterielPedagogique> materielPedagogiques = MaterielPedagogiqueFactory.getAllMaterielPedagogique();
        MaterielPedagogiqueAdapater materielPedagogiqueAdapater = new MaterielPedagogiqueAdapater(materielPedagogiques,applicationContext);
        recyclerView.setAdapter(materielPedagogiqueAdapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(applicationContext));
        // Inflate the layout for this fragment
        return view;
    }

}
