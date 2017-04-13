package com.flst.fges.musehome.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.manager.CollectionsManager;
import com.flst.fges.musehome.data.model.Collection;
import com.flst.fges.musehome.ui.activity.CollectionActivity;
import com.flst.fges.musehome.ui.adapter.CollectionsAdapater;
import com.flst.fges.musehome.ui.helper.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CollectionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CollectionsFragment extends Fragment {


    private CollectionsManager manager;
    private List<Collection> collectionsList = new ArrayList<>();

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
        final CollectionsAdapater collectionsAdapater = new CollectionsAdapater(collectionsList,applicationContext);
        manager = new CollectionsManager();
        manager.getAllCollections(new ICallback<List<Collection>>() {
            @Override
            public void success(List<Collection> collections) {
                collectionsList.clear();
                collectionsList.addAll(collections);
                collectionsAdapater.notifyDataSetChanged();
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERREUR",error);
            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Collection collection = collectionsAdapater.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), CollectionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("COLLECTION",collection.getNom());
                getContext().startActivity(intent);
            }
        }));
        recyclerView.setAdapter(collectionsAdapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(applicationContext));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        return view;
    }

}
