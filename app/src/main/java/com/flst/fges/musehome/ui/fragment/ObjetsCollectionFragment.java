package com.flst.fges.musehome.ui.fragment;


import android.content.Context;
import android.content.Intent;
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
import com.flst.fges.musehome.data.manager.HerbiersManager;
import com.flst.fges.musehome.data.manager.InstrumentsManager;
import com.flst.fges.musehome.data.manager.JardinBotaniqueManager;
import com.flst.fges.musehome.data.manager.MaterielPedagogiqueManager;
import com.flst.fges.musehome.data.manager.MineralogieCristallographieManager;
import com.flst.fges.musehome.data.manager.OuvragesCartesDocumentsManager;
import com.flst.fges.musehome.data.manager.PaleontologieAnimaleManager;
import com.flst.fges.musehome.data.manager.PaleontologieVegetaleManager;
import com.flst.fges.musehome.data.manager.PetrographieManager;
import com.flst.fges.musehome.data.manager.PhysiqueManager;
import com.flst.fges.musehome.data.manager.TypothequeManager;
import com.flst.fges.musehome.data.manager.ZoologieInvertebresAutresManager;
import com.flst.fges.musehome.data.manager.ZoologieInvertebresInsectesManager;
import com.flst.fges.musehome.data.manager.ZoologieInvertebresMollusquesManager;
import com.flst.fges.musehome.data.manager.ZoologieVertebresAutresManager;
import com.flst.fges.musehome.data.manager.ZoologieVertebresMammiferesManager;
import com.flst.fges.musehome.data.manager.ZoologieVertebresPoissonsManager;
import com.flst.fges.musehome.data.manager.ZoologieVertebresPrimatesManager;
import com.flst.fges.musehome.data.manager.ZoologieVertebresReptileManager;
import com.flst.fges.musehome.data.model.DefaultClassCollection;
import com.flst.fges.musehome.data.model.Herbiers;
import com.flst.fges.musehome.data.model.Instruments;
import com.flst.fges.musehome.data.model.JardinBotanique;
import com.flst.fges.musehome.data.model.MaterielPedagogique;
import com.flst.fges.musehome.data.model.MineralogieCristallographie;
import com.flst.fges.musehome.data.model.OuvragesCartesDocuments;
import com.flst.fges.musehome.data.model.PaleontologieAnimale;
import com.flst.fges.musehome.data.model.PaleontologieVegetale;
import com.flst.fges.musehome.data.model.Petrographie;
import com.flst.fges.musehome.data.model.Physique;
import com.flst.fges.musehome.data.model.Typotheque;
import com.flst.fges.musehome.data.model.ZoologieInvertebresAutres;
import com.flst.fges.musehome.data.model.ZoologieInvertebresInsectes;
import com.flst.fges.musehome.data.model.ZoologieInvertebresMollusques;
import com.flst.fges.musehome.data.model.ZoologieVertebresAutres;
import com.flst.fges.musehome.data.model.ZoologieVertebresMammiferes;
import com.flst.fges.musehome.data.model.ZoologieVertebresPoissons;
import com.flst.fges.musehome.data.model.ZoologieVertebresPrimates;
import com.flst.fges.musehome.data.model.ZoologieVertebresReptile;
import com.flst.fges.musehome.ui.activity.ObjetsDetailActivity;
import com.flst.fges.musehome.ui.adapter.DefaultClassCollectionAdapater;
import com.flst.fges.musehome.ui.helper.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ObjetsCollectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ObjetsCollectionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_COLLECTION = "objet";
    private static String mCollection;

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
        mCollection = paramCollection;
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
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.collections_objets_list);
        checkCollection(recyclerView,applicationContext);
        recyclerView.setLayoutManager(new LinearLayoutManager(applicationContext));
        // Inflate the layout for this fragment
        return view;
    }

    private void checkCollection(RecyclerView recyclerView,Context applicationContext){
        switch (mCollection){
            case "Herbiers":
                HerbiersManager herbiersManager = new HerbiersManager();
                final ArrayList<Herbiers> herbiers = new ArrayList<>();
                final DefaultClassCollectionAdapater<Herbiers> herbiersAdapater = new DefaultClassCollectionAdapater<>(herbiers,applicationContext);
                herbiersManager.getAllHerbiers(new ICallback<List<Herbiers>>() {
                    @Override
                    public void success(List<Herbiers> herbiersList) {
                        herbiers.clear();
                        herbiers.addAll(herbiersList);
                        herbiersAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(herbiersAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Herbiers herbiers1 = (Herbiers) herbiersAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",herbiers1.getId());
                        intent.putExtra("COLLECTION",herbiers1.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Instruments":
                InstrumentsManager instrumentsManager = new InstrumentsManager();
                final ArrayList<Instruments> instrumentses = new ArrayList<>();
                final DefaultClassCollectionAdapater<Instruments> instrumentsAdapater = new DefaultClassCollectionAdapater<>(instrumentses,applicationContext);
                instrumentsManager.getAllInstruments(new ICallback<List<Instruments>>() {
                    @Override
                    public void success(List<Instruments> instrumentsList) {
                        instrumentses.clear();
                        instrumentses.addAll(instrumentsList);
                        instrumentsAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(instrumentsAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Instruments instruments = (Instruments) instrumentsAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",instruments.getId());
                        intent.putExtra("COLLECTION",instruments.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Jardin botanique":
                JardinBotaniqueManager jardinBotaniqueManager = new JardinBotaniqueManager();
                final ArrayList<JardinBotanique> botaniques = new ArrayList<>();
                final DefaultClassCollectionAdapater<JardinBotanique> jardinBotaniqueAdapater = new DefaultClassCollectionAdapater<>(botaniques,applicationContext);
                jardinBotaniqueManager.getAllJardinBotanique(new ICallback<List<JardinBotanique>>() {
                    @Override
                    public void success(List<JardinBotanique> jardinBotaniques) {
                        botaniques.clear();
                        botaniques.addAll(jardinBotaniques);
                        jardinBotaniqueAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(jardinBotaniqueAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        JardinBotanique jardinBotanique = (JardinBotanique) jardinBotaniqueAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",jardinBotanique.getId());
                        intent.putExtra("COLLECTION",jardinBotanique.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Materiel Pedagogique":
                MaterielPedagogiqueManager materielPedagogiqueManager = new MaterielPedagogiqueManager();
                final ArrayList<MaterielPedagogique> pedagogiques = new ArrayList<>();
                final DefaultClassCollectionAdapater<MaterielPedagogique> materielPedagogiqueAdapater = new DefaultClassCollectionAdapater<>(pedagogiques,applicationContext);
                materielPedagogiqueManager.getAllMaterielPedagogique(new ICallback<List<MaterielPedagogique>>() {
                    @Override
                    public void success(List<MaterielPedagogique> materielPedagogiques) {
                        pedagogiques.clear();
                        pedagogiques.addAll(materielPedagogiques);
                        materielPedagogiqueAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(materielPedagogiqueAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        MaterielPedagogique materielPedagogique = (MaterielPedagogique) materielPedagogiqueAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",materielPedagogique.getId());
                        intent.putExtra("COLLECTION",materielPedagogique.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Mineralogie - Cristallographie":
                MineralogieCristallographieManager mineralogieCristallographieManager = new MineralogieCristallographieManager();
                final ArrayList<MineralogieCristallographie> cristallographies = new ArrayList<>();
                final DefaultClassCollectionAdapater<MineralogieCristallographie> mineralogieCristallographieAdapater = new DefaultClassCollectionAdapater<>(cristallographies,applicationContext);
                mineralogieCristallographieManager.getAllMineralogieCristallographie(new ICallback<List<MineralogieCristallographie>>() {
                    @Override
                    public void success(List<MineralogieCristallographie> mineralogieCristallographies) {
                        cristallographies.clear();
                        cristallographies.addAll(mineralogieCristallographies);
                        mineralogieCristallographieAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(mineralogieCristallographieAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        MineralogieCristallographie mineralogieCristallographie = (MineralogieCristallographie) mineralogieCristallographieAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",mineralogieCristallographie.getId());
                        intent.putExtra("COLLECTION",mineralogieCristallographie.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Ouvrages Cartes Documents":
                OuvragesCartesDocumentsManager ouvragesCartesDocumentsManager = new OuvragesCartesDocumentsManager();
                final ArrayList<OuvragesCartesDocuments> cartesDocumentses = new ArrayList<>();
                final DefaultClassCollectionAdapater<OuvragesCartesDocuments> ouvragesCartesDocumentsAdapater = new DefaultClassCollectionAdapater<>(cartesDocumentses,applicationContext);
                ouvragesCartesDocumentsManager.getAllOuvragesCartesDocuments(new ICallback<List<OuvragesCartesDocuments>>() {
                    @Override
                    public void success(List<OuvragesCartesDocuments> ouvragesCartesDocumentses) {
                        cartesDocumentses.clear();
                        cartesDocumentses.addAll(ouvragesCartesDocumentses);
                        ouvragesCartesDocumentsAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(ouvragesCartesDocumentsAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        OuvragesCartesDocuments ouvragesCartesDocuments = (OuvragesCartesDocuments) ouvragesCartesDocumentsAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",ouvragesCartesDocuments.getId());
                        intent.putExtra("COLLECTION",ouvragesCartesDocuments.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Paleontologie Animale":
                PaleontologieAnimaleManager paleontologieAnimaleManager = new PaleontologieAnimaleManager();
                final ArrayList<PaleontologieAnimale> animales = new ArrayList<>();
                final DefaultClassCollectionAdapater<PaleontologieAnimale> paleontologieAnimaleAdapater = new DefaultClassCollectionAdapater<>(animales,applicationContext);
                paleontologieAnimaleManager.getAllPaleontologieAnimale(new ICallback<List<PaleontologieAnimale>>() {
                    @Override
                    public void success(List<PaleontologieAnimale> paleontologieAnimales) {
                        animales.clear();
                        animales.addAll(paleontologieAnimales);
                        paleontologieAnimaleAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(paleontologieAnimaleAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        PaleontologieAnimale paleontologieAnimale = (PaleontologieAnimale) paleontologieAnimaleAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",paleontologieAnimale.getId());
                        intent.putExtra("COLLECTION",paleontologieAnimale.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Paleontologie Vegetale":
                PaleontologieVegetaleManager paleontologieVegetaleManager = new PaleontologieVegetaleManager();
                final ArrayList<PaleontologieVegetale> vegetales = new ArrayList<>();
                final DefaultClassCollectionAdapater<PaleontologieVegetale> paleontologieVegetaleAdapater = new DefaultClassCollectionAdapater<>(vegetales,applicationContext);
                paleontologieVegetaleManager.getAllPaleontologieVegetale(new ICallback<List<PaleontologieVegetale>>() {
                    @Override
                    public void success(List<PaleontologieVegetale> paleontologieVegetales) {
                        vegetales.clear();
                        vegetales.addAll(paleontologieVegetales);
                        paleontologieVegetaleAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(paleontologieVegetaleAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        PaleontologieVegetale paleontologieVegetale = (PaleontologieVegetale) paleontologieVegetaleAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",paleontologieVegetale.getId());
                        intent.putExtra("COLLECTION",paleontologieVegetale.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Petrographie":
                PetrographieManager petrographieManager = new PetrographieManager();
                final ArrayList<Petrographie> petrographies = new ArrayList<>();
                final DefaultClassCollectionAdapater<Petrographie> petrographieAdapater = new DefaultClassCollectionAdapater<>(petrographies,applicationContext);
                petrographieManager.getAllPetrographie(new ICallback<List<Petrographie>>() {
                    @Override
                    public void success(List<Petrographie> petrographieList) {
                        petrographies.clear();
                        petrographies.addAll(petrographieList);
                        petrographieAdapater.notifyDataSetChanged();

                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(petrographieAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Petrographie petrographie = (Petrographie) petrographieAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",petrographie.getId());
                        intent.putExtra("COLLECTION",petrographie.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Physique":
                PhysiqueManager physiqueManager = new PhysiqueManager();
                final ArrayList<Physique> physiques = new ArrayList<>();
                final DefaultClassCollectionAdapater<Physique> physiqueAdapater = new DefaultClassCollectionAdapater<>(physiques,applicationContext);
                physiqueManager.getAllPhysique(new ICallback<List<Physique>>() {
                    @Override
                    public void success(List<Physique> physiqueList) {
                        physiques.clear();
                        physiques.addAll(physiqueList);
                        physiqueAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(physiqueAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Physique physique = (Physique) physiqueAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",physique.getId());
                        intent.putExtra("COLLECTION",physique.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Typotheque":
                TypothequeManager typothequeManager = new TypothequeManager();
                final ArrayList<Typotheque> typotheques = new ArrayList<>();
                final DefaultClassCollectionAdapater<Typotheque> typothequeAdapater = new DefaultClassCollectionAdapater<>(typotheques,applicationContext);
                typothequeManager.getAllTypotheque(new ICallback<List<Typotheque>>() {
                    @Override
                    public void success(List<Typotheque> typothequeList) {
                        typotheques.clear();
                        typotheques.addAll(typothequeList);
                        typothequeAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(typothequeAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Typotheque typotheque = (Typotheque) typothequeAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",typotheque.getId());
                        intent.putExtra("COLLECTION",typotheque.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Zoologie Invertebres Autres":
                ZoologieInvertebresAutresManager zoologieInvertebresAutresManager =
                        new ZoologieInvertebresAutresManager();
                final ArrayList<ZoologieInvertebresAutres> invertebresAutres = new ArrayList<>();
                final DefaultClassCollectionAdapater<ZoologieInvertebresAutres> invertebresAutresAdapater =
                        new DefaultClassCollectionAdapater<>(invertebresAutres,applicationContext);
                zoologieInvertebresAutresManager.getAllZoologieInvertebresAutres(new ICallback<List<ZoologieInvertebresAutres>>() {
                    @Override
                    public void success(List<ZoologieInvertebresAutres> zoologieInvertebresAutres) {
                        invertebresAutres.clear();
                        invertebresAutres.addAll(zoologieInvertebresAutres);
                        invertebresAutresAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(invertebresAutresAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ZoologieInvertebresAutres zoologieInvertebresAutres = (ZoologieInvertebresAutres) invertebresAutresAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",zoologieInvertebresAutres.getId());
                        intent.putExtra("COLLECTION",zoologieInvertebresAutres.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Zoologie Invertebres Insectes":
                ZoologieInvertebresInsectesManager insectesManager = new ZoologieInvertebresInsectesManager();
                final ArrayList<ZoologieInvertebresInsectes> invertebresInsectes = new ArrayList<>();
                final DefaultClassCollectionAdapater<ZoologieInvertebresInsectes> insectesAdapater =
                        new DefaultClassCollectionAdapater<>(invertebresInsectes,applicationContext);
                insectesManager.getAllZoologieInvertebresInsectes(new ICallback<List<ZoologieInvertebresInsectes>>() {
                    @Override
                    public void success(List<ZoologieInvertebresInsectes> zoologieInvertebresInsectes) {
                        invertebresInsectes.clear();
                        invertebresInsectes.addAll(zoologieInvertebresInsectes);
                        insectesAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(insectesAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ZoologieInvertebresInsectes zoologieInvertebresInsectes = (ZoologieInvertebresInsectes) insectesAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",zoologieInvertebresInsectes.getId());
                        intent.putExtra("COLLECTION",zoologieInvertebresInsectes.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Zoologie Invertebres Mollusques":
                ZoologieInvertebresMollusquesManager mollusquesManager = new ZoologieInvertebresMollusquesManager();
                final ArrayList<ZoologieInvertebresMollusques> invertebresMollusques = new ArrayList<>();
                final DefaultClassCollectionAdapater<ZoologieInvertebresMollusques> mollusquesAdapater =
                        new DefaultClassCollectionAdapater<>(invertebresMollusques,applicationContext);
                mollusquesManager.getAllZoologieInvertebresMollusques(new ICallback<List<ZoologieInvertebresMollusques>>() {
                    @Override
                    public void success(List<ZoologieInvertebresMollusques> zoologieInvertebresMollusques) {
                        invertebresMollusques.clear();
                        invertebresMollusques.addAll(zoologieInvertebresMollusques);
                        mollusquesAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(mollusquesAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ZoologieInvertebresMollusques zoologieInvertebresMollusques = (ZoologieInvertebresMollusques) mollusquesAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",zoologieInvertebresMollusques.getId());
                        intent.putExtra("COLLECTION",zoologieInvertebresMollusques.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Zoologie Vertebres Autres":
                ZoologieVertebresAutresManager vertebresAutresManager = new ZoologieVertebresAutresManager();
                final ArrayList<ZoologieVertebresAutres> vertebresAutres = new ArrayList<>();
                final DefaultClassCollectionAdapater<ZoologieVertebresAutres> zoologieVertebresAutresAdapater =
                        new DefaultClassCollectionAdapater<>(vertebresAutres,applicationContext);
                vertebresAutresManager.getAllZoologieVertebresAutres(new ICallback<List<ZoologieVertebresAutres>>() {
                    @Override
                    public void success(List<ZoologieVertebresAutres> zoologieVertebresAutres) {
                        vertebresAutres.clear();
                        vertebresAutres.addAll(zoologieVertebresAutres);
                        zoologieVertebresAutresAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(zoologieVertebresAutresAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ZoologieVertebresAutres zoologieVertebresAutres = (ZoologieVertebresAutres) zoologieVertebresAutresAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",zoologieVertebresAutres.getId());
                        intent.putExtra("COLLECTION",zoologieVertebresAutres.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Zoologie Vertebres Mammiferes":
                ZoologieVertebresMammiferesManager mammiferesManager = new ZoologieVertebresMammiferesManager();
                final ArrayList<ZoologieVertebresMammiferes> vertebresMammiferes = new ArrayList<>();
                final DefaultClassCollectionAdapater<ZoologieVertebresMammiferes> mammiferesAdapater =
                        new DefaultClassCollectionAdapater<>(vertebresMammiferes,applicationContext);
                mammiferesManager.getAllZoologieVertebresMammiferes(new ICallback<List<ZoologieVertebresMammiferes>>() {
                    @Override
                    public void success(List<ZoologieVertebresMammiferes> zoologieVertebresMammiferes) {
                        vertebresMammiferes.clear();
                        vertebresMammiferes.addAll(zoologieVertebresMammiferes);
                        mammiferesAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(mammiferesAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ZoologieVertebresMammiferes zoologieVertebresMammiferes = (ZoologieVertebresMammiferes) mammiferesAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",zoologieVertebresMammiferes.getId());
                        intent.putExtra("COLLECTION",zoologieVertebresMammiferes.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Zoologie Vertebres Poissons":
                ZoologieVertebresPoissonsManager vertebresPoissonsManager = new ZoologieVertebresPoissonsManager();
                final ArrayList<ZoologieVertebresPoissons> vertebresPoissonses = new ArrayList<>();
                final DefaultClassCollectionAdapater<ZoologieVertebresPoissons> poissonsAdapater =
                        new DefaultClassCollectionAdapater<>(vertebresPoissonses,applicationContext);
                vertebresPoissonsManager.getAllZoologieVertebresPoissons(new ICallback<List<ZoologieVertebresPoissons>>() {
                    @Override
                    public void success(List<ZoologieVertebresPoissons> zoologieVertebresPoissonses) {
                        vertebresPoissonses.clear();
                        vertebresPoissonses.addAll(zoologieVertebresPoissonses);
                        poissonsAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(poissonsAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ZoologieVertebresPoissons zoologieVertebresPoissons = (ZoologieVertebresPoissons) poissonsAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",zoologieVertebresPoissons.getId());
                        intent.putExtra("COLLECTION",zoologieVertebresPoissons.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Zoologie Vertebres Primates":
                ZoologieVertebresPrimatesManager primatesManager = new ZoologieVertebresPrimatesManager();
                final ArrayList<ZoologieVertebresPrimates> vertebresPrimates = new ArrayList<>();
                final DefaultClassCollectionAdapater<ZoologieVertebresPrimates> primatesAdapater =
                        new DefaultClassCollectionAdapater<>(vertebresPrimates,applicationContext);
                primatesManager.getAllZoologieVertebresPrimates(new ICallback<List<ZoologieVertebresPrimates>>() {
                    @Override
                    public void success(List<ZoologieVertebresPrimates> zoologieVertebresPrimates) {
                        vertebresPrimates.clear();
                        vertebresPrimates.addAll(zoologieVertebresPrimates);
                        primatesAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(primatesAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ZoologieVertebresPrimates zoologieVertebresPrimates = (ZoologieVertebresPrimates) primatesAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",zoologieVertebresPrimates.getId());
                        intent.putExtra("COLLECTION",zoologieVertebresPrimates.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            case "Zoologie Vertebres Reptile":
                ZoologieVertebresReptileManager reptileManager = new ZoologieVertebresReptileManager();
                final ArrayList<ZoologieVertebresReptile> vertebresReptiles = new ArrayList<>();
                final DefaultClassCollectionAdapater<ZoologieVertebresReptile> reptileAdapater =
                        new DefaultClassCollectionAdapater<>(vertebresReptiles,applicationContext);
                reptileManager.getAllZoologieVertebresReptile(new ICallback<List<ZoologieVertebresReptile>>() {
                    @Override
                    public void success(List<ZoologieVertebresReptile> zoologieVertebresReptiles) {
                        vertebresReptiles.clear();
                        vertebresReptiles.addAll(zoologieVertebresReptiles);
                        reptileAdapater.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.w("ERROR",error);
                    }
                });
                recyclerView.setAdapter(reptileAdapater);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(applicationContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ZoologieVertebresReptile vertebresReptile = (ZoologieVertebresReptile) reptileAdapater.getItemAtPosition(position);
                        Intent intent = new Intent(getContext(), ObjetsDetailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("OBJET",vertebresReptile.getId());
                        intent.putExtra("COLLECTION",vertebresReptile.getClass().getSimpleName());
                        getContext().startActivity(intent);
                    }
                }));
                break;
            default:
                ArrayList<DefaultClassCollection> defaultClassCollections = new ArrayList<>();
                DefaultClassCollectionAdapater<DefaultClassCollection> adapater = new DefaultClassCollectionAdapater<>(defaultClassCollections,applicationContext);
                recyclerView.setAdapter(adapater);
        }
    }

}
