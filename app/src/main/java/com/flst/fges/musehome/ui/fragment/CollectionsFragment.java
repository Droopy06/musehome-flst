package com.flst.fges.musehome.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.database.manager.CollectionManagerSQLite;
import com.flst.fges.musehome.data.manager.CollectionsManager;
import com.flst.fges.musehome.data.model.Collection;
import com.flst.fges.musehome.ui.activity.CollectionActivity;
import com.flst.fges.musehome.ui.adapter.CollectionsAdapater;
import com.flst.fges.musehome.ui.helper.NetworkHelper;
import com.flst.fges.musehome.ui.helper.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CollectionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CollectionsFragment extends Fragment {


    private CollectionsManager manager;
    private List<Collection> collectionsList = new ArrayList<>();

    @BindView(R.id.swipeCollectionsContainer)
    SwipeRefreshLayout swipeCollectionsContainer;
    @BindView(R.id.collections_list)
    RecyclerView recyclerView;
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
        ButterKnife.bind(this,view);
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
        CollectionManagerSQLite collectionManagerSQLite = new CollectionManagerSQLite(applicationContext);
        swipeCollectionsContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                if(NetworkHelper.checkNetwork(applicationContext)){
                    manager.getAllCollections(new ICallback<List<Collection>>() {
                        @Override
                        public void success(List<Collection> collections) {
                            collectionsList.clear();
                            collectionsList.addAll(collections);
                            collectionsAdapater.notifyDataSetChanged();
                            swipeCollectionsContainer.setRefreshing(false);
                        }

                        @Override
                        public void failure(Throwable error) {
                            Log.w("ERREUR",error);
                        }
                    });
                }else{
                    collectionsList.clear();
                    collectionsList.addAll(collectionManagerSQLite.getAllCollection());
                    collectionsAdapater.notifyDataSetChanged();
                    swipeCollectionsContainer.setRefreshing(false);
                }
            }
        });
        // Configure the refreshing colors
        swipeCollectionsContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        return view;
    }

}
