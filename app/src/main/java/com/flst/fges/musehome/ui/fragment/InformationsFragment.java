package com.flst.fges.musehome.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.factory.PersonsFactory;
import com.flst.fges.musehome.data.model.Persons;
import com.flst.fges.musehome.ui.adapter.PersonsAdapater;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InformationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformationsFragment extends Fragment {

    @BindView(R.id.developers_recyclerview)
    RecyclerView developerRecyclerView;
    @BindView(R.id.supervision_recyclerview)
    RecyclerView supervisionRecyclerView;
    private PersonsAdapater personsDeveloperAdapater;
    private PersonsAdapater personsSupervisionAdapater;

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
        ArrayList<Persons> developers = PersonsFactory.getDevelopers();
        ArrayList<Persons> supervisions = PersonsFactory.getSupervision();
        personsDeveloperAdapater = new PersonsAdapater(developers,getActivity().getApplicationContext());
        personsSupervisionAdapater = new PersonsAdapater(supervisions,getActivity().getApplicationContext());
        developerRecyclerView.setAdapter(personsDeveloperAdapater);
        supervisionRecyclerView.setAdapter(personsSupervisionAdapater);
        developerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        supervisionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(developerRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        developerRecyclerView.addItemDecoration(dividerItemDecoration);
        supervisionRecyclerView.addItemDecoration(dividerItemDecoration);
        return view;
    }

}
