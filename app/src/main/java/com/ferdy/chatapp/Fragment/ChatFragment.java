package com.ferdy.chatapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ferdy.chatapp.MessageAdapter;
import com.ferdy.chatapp.MessageDetail;
import com.ferdy.chatapp.R;

import java.util.ArrayList;


public class ChatFragment extends android.support.v4.app.Fragment{

    ListView messageList;
    ArrayList<MessageDetail> details;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.chat_fragment, container, false);

        messageList = (ListView) view.findViewById(R.id.message_list);
        details = new ArrayList<>();

        MessageDetail Detail;
        Detail = new MessageDetail();
        Detail.setUsername("Test");
        Detail.setMessage("Test message");
        Detail.setTime("12/12/2012");
        details.add(Detail);

        Detail = new MessageDetail();
        Detail.setUsername("Test");
        Detail.setMessage("Test message");
        Detail.setTime("12/12/2012");
        details.add(Detail);

        MessageAdapter adapter = new MessageAdapter(details,getContext());

        messageList.setAdapter(adapter);

        return view;
    }
}
