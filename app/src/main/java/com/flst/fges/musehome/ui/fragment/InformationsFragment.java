package com.flst.fges.musehome.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.factory.PersonsFactory;
import com.flst.fges.musehome.ui.vewholder.PersonsSection;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InformationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformationsFragment extends Fragment {

    @BindView(R.id.supervision_recyclerview)
    RecyclerView developerRecyclerView;
    private SectionedRecyclerViewAdapter sectionAdapter;

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
        ButterKnife.bind(this,view);
        sectionAdapter = new SectionedRecyclerViewAdapter();
        sectionAdapter.addSection(new PersonsSection(getActivity().getApplicationContext(),getString(R.string.supervision_projet), PersonsFactory.getSupervision()));
        sectionAdapter.addSection(new PersonsSection(getActivity().getApplicationContext(),getString(R.string.developers), PersonsFactory.getDevelopers()));
        GridLayoutManager glm = new GridLayoutManager(getContext(), 2);
        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(sectionAdapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        developerRecyclerView.setLayoutManager(glm);
        developerRecyclerView.setAdapter(sectionAdapter);
        developerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(developerRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        developerRecyclerView.addItemDecoration(dividerItemDecoration);
        return view;
    }

}
