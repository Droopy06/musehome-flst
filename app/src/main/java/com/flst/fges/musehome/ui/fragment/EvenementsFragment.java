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
import com.flst.fges.musehome.data.database.manager.EvenementManagerSQLite;
import com.flst.fges.musehome.data.manager.EvenementsManager;
import com.flst.fges.musehome.data.model.Evenement;
import com.flst.fges.musehome.ui.activity.EvenementDetailActivity;
import com.flst.fges.musehome.ui.adapter.EvenementsAdapater;
import com.flst.fges.musehome.ui.helper.NetworkHelper;
import com.flst.fges.musehome.ui.helper.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EvenementsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EvenementsFragment extends Fragment {


    private EvenementsManager evenementsManager;
    private List<Evenement> evenementList = new ArrayList<>();

    @BindView(R.id.swipeEvenementsContainer)
    SwipeRefreshLayout swipeEvenementsContainer;
    @BindView(R.id.evenements_list)
    RecyclerView recyclerView;

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
        ButterKnife.bind(this,view);
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
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Evenement evenement = evenementsAdapater.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), EvenementDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("EVENEMENT",evenement.getTitre());
                getContext().startActivity(intent);
            }
        }));
        recyclerView.setAdapter(evenementsAdapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(applicationContext));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        EvenementManagerSQLite evenementManagerSQLite = new EvenementManagerSQLite(applicationContext);
        swipeEvenementsContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                if(NetworkHelper.checkNetwork(applicationContext)){
                    evenementsManager.getAllEvenements(new ICallback<List<Evenement>>() {
                        @Override
                        public void success(List<Evenement> evenements) {
                            evenementList.clear();
                            evenementList.addAll(evenements);
                            evenementsAdapater.notifyDataSetChanged();
                            swipeEvenementsContainer.setRefreshing(false);
                        }

                        @Override
                        public void failure(Throwable error) {
                            Log.w("ERROR",error);
                        }
                    });
                }else{
                    evenementList.clear();
                    evenementList.addAll(evenementManagerSQLite.getAllEvenement());
                    evenementsAdapater.notifyDataSetChanged();
                    swipeEvenementsContainer.setRefreshing(false);
                }
            }
        });
        // Configure the refreshing colors
        swipeEvenementsContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        return view;
    }

}
