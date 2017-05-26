package com.flst.fges.musehome.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.helper.UrlHelper;
import com.flst.fges.musehome.data.manager.CollectionsDetailsManager;
import com.flst.fges.musehome.data.manager.DefaultClassCollectionManager;
import com.flst.fges.musehome.data.model.CollectionDetails;
import com.flst.fges.musehome.data.model.DefaultClassCollection;
import com.flst.fges.musehome.ui.adapter.ObjetsDetailAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ObjetsDetailActivity extends AppCompatActivity {

    Map<String,String> informations;
    ArrayList<String> keyHeaderMap;
    ObjetsDetailAdapter objetsDetailAdapter;
    @BindView(R.id.object_collection_imageview)
    ImageView imageView;
    @BindView(R.id.object_collection_recyclerview)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objets_detail);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.banniere);
        actionBar.setDisplayUseLogoEnabled(true);
        ButterKnife.bind(this);
        informations = new HashMap<>();
        keyHeaderMap = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        objetsDetailAdapter = new ObjetsDetailAdapter(informations);
        recyclerView.setAdapter(objetsDetailAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        CollectionsDetailsManager collectionsDetailsManager = new CollectionsDetailsManager();
        collectionsDetailsManager.getCollectionsDetailsByName(getIntent().getStringExtra("COLLECTION").replace(" ", "").toLowerCase(), new ICallback<CollectionDetails>() {
            @Override
            public void success(CollectionDetails collectionDetails) {
                informations.put(collectionDetails.getName(), "");
                keyHeaderMap.add(collectionDetails.getName());
                informations.put(collectionDetails.getGroupe(), "");
                keyHeaderMap.add(collectionDetails.getGroupe());
                informations.put(collectionDetails.getKind(), "");
                keyHeaderMap.add(collectionDetails.getKind());
                informations.put(collectionDetails.getEspece(), "");
                keyHeaderMap.add(collectionDetails.getEspece());
                informations.put(collectionDetails.getAuthor(), "");
                keyHeaderMap.add(collectionDetails.getAuthor());
                informations.put(collectionDetails.getYear(), "");
                keyHeaderMap.add(collectionDetails.getYear());
                informations.put(collectionDetails.getCountry(), "");
                keyHeaderMap.add(collectionDetails.getCountry());
                informations.put(collectionDetails.getCity(), "");
                keyHeaderMap.add(collectionDetails.getCity());
                informations.put(collectionDetails.getPlace(), "");
                keyHeaderMap.add(collectionDetails.getPlace());
                informations.put(collectionDetails.getNameCollection(), "");
                keyHeaderMap.add(collectionDetails.getNameCollection());
                informations.put(collectionDetails.getManifold(), "");
                keyHeaderMap.add(collectionDetails.getManifold());
                informations.put(collectionDetails.getLocalization(), "");
                keyHeaderMap.add(collectionDetails.getLocalization());
                launchDetailObject(getIntent().getStringExtra("OBJET").split(" ")[0]);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR", error);
            }
        });
    }

    public void launchDetailObject(String id){
        DefaultClassCollectionManager defaultClassCollectionManager = new DefaultClassCollectionManager();
        defaultClassCollectionManager.getDefaultClassCollectionByName(getIntent().getStringExtra("COLLECTION").replace(" ", "").toLowerCase(), id, new ICallback<DefaultClassCollection>() {
            @Override
            public void success(DefaultClassCollection defaultClassCollection) {
                Picasso.with(getApplicationContext())
                        .load("http://"+ UrlHelper.BASE_URL_API +"/patrimoine/images/Collections/"+
                                getIntent().getStringExtra("COLLECTION").replace(" ", "").toLowerCase()+
                                "/"+defaultClassCollection.getPicture())
                        .error(R.drawable.image_download_error_24dp)
                        .placeholder(R.drawable.loading)
                        .into(imageView);
                informations.put(keyHeaderMap.get(0),defaultClassCollection.getName());
                informations.put(keyHeaderMap.get(1),defaultClassCollection.getGroupe());
                informations.put(keyHeaderMap.get(2),defaultClassCollection.getKind());
                informations.put(keyHeaderMap.get(3),defaultClassCollection.getEspece());
                informations.put(keyHeaderMap.get(4),defaultClassCollection.getAuthor());
                informations.put(keyHeaderMap.get(5),defaultClassCollection.getYear());
                informations.put(keyHeaderMap.get(6),defaultClassCollection.getCountry());
                informations.put(keyHeaderMap.get(7),defaultClassCollection.getCity());
                informations.put(keyHeaderMap.get(8),defaultClassCollection.getPlace());
                informations.put(keyHeaderMap.get(9),defaultClassCollection.getNameCollection());
                informations.put(keyHeaderMap.get(10),defaultClassCollection.getManifold());
                informations.put(keyHeaderMap.get(11),defaultClassCollection.getLocalization());
                objetsDetailAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }
}
