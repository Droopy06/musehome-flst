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
import com.flst.fges.musehome.data.model.Collection;
import com.flst.fges.musehome.ui.adapter.CollectionsAdapater;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CollectionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CollectionsFragment extends Fragment {


    public CollectionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CollectionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CollectionsFragment newInstance() {
        CollectionsFragment fragment = new CollectionsFragment();
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
        Context applicationContext = getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.fragment_collections, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.collections_list);
        ArrayList<Collection> collectionsList = CollectionFactory.getAllCollections();
        CollectionsAdapater collectionsAdapater = new CollectionsAdapater(collectionsList,applicationContext);
        recyclerView.setAdapter(collectionsAdapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(applicationContext));
        return view;
    }

}
