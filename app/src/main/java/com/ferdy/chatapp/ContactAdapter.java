package com.ferdy.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    private ArrayList<ContactDetail> data;
    Context context;

    public ContactAdapter(ArrayList<ContactDetail> data, Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int position) {
        return this.data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_contact, null);
        }

        TextView usernameView = (TextView) view.findViewById(R.id.contact_username);
        TextView statusView = (TextView) view.findViewById(R.id.contact_status);

        ContactDetail contactDetail = data.get(position);
        usernameView.setText(contactDetail.username);
        statusView.setText(contactDetail.status);

        return view;
    }
}
