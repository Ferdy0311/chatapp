package com.ferdy.chatapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ferdy.chatapp.ContactAdapter;
import com.ferdy.chatapp.ContactDetail;
import com.ferdy.chatapp.R;

import java.util.ArrayList;

public class ContactFragment extends android.support.v4.app.Fragment {

    ListView contactList;
    ArrayList<ContactDetail> details;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.contact_fragment, container, false);

        contactList = (ListView) view.findViewById(R.id.contact_list);
        details = new ArrayList<>();

        ContactDetail Detail;
        Detail = new ContactDetail();
        Detail.setUsername("Test");
        Detail.setStatus("Hello hello");
        details.add(Detail);

        ContactAdapter adapter = new ContactAdapter(details, getContext());
        contactList.setAdapter(adapter);

        return view;
    }
}
