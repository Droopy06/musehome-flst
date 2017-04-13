package com.flst.fges.musehome.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.manager.ContactManager;
import com.flst.fges.musehome.data.model.Contact;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    @BindView(value = R.id.contact_button)
    Button buttonSubmit;
    @BindView(value = R.id.nom_edittext)
    EditText nomEditText;
    @BindView(value = R.id.prenom_edittext)
    EditText prenomEditText;
    @BindView(value = R.id.email_edittext)
    EditText emailEditText;
    @BindView(value = R.id.sujet_edittext)
    EditText sujetEditText;
    @BindView(value = R.id.message_edittext)
    EditText messageEditText;

    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this,view);
        // Inflate the layout for this fragment
        return view;
    }

    @OnClick(value = R.id.contact_button)
    public void sendContactByUser(){
        Contact contact = new Contact();
        contact.setName(prenomEditText.getText().toString());
        contact.setLastName(nomEditText.getText().toString());
        contact.setMail(emailEditText.getText().toString());
        contact.setSubject(sujetEditText.getText().toString());
        contact.setMessage(messageEditText.getText().toString());
        ContactManager contactManager = new ContactManager();
        contactManager.saveContact(contact, new ICallback<Contact>() {
            @Override
            public void success(Contact contact) {
                Snackbar.make(getView(),"Votre message a été envoyé",Snackbar.LENGTH_LONG).show();
                prenomEditText.setText("");
                nomEditText.setText("");
                emailEditText.setText("");
                sujetEditText.setText("");
                messageEditText.setText("");
            }

            @Override
            public void failure(Throwable error) {
                Snackbar.make(getView(),"Votre message n'a pas été envoyé",Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
