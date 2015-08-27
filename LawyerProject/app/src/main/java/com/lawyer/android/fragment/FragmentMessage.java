package com.lawyer.android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.adapter.MessageAdapter;
import com.lawyer.android.bean.MessageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class FragmentMessage extends Fragment {
    private List<MessageItem> messageItems;
    private ListView mListView;
    public FragmentMessage() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_fragment_message, null);

        mListView = (ListView) view.findViewById(R.id.toolListView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData(){
        messageItems=getMessageItems();
        mListView.setAdapter(new MessageAdapter(getActivity(),messageItems));
    }

    private List<MessageItem> getMessageItems(){
        List<MessageItem> list=new ArrayList<>();
        list.add(new MessageItem(1,"titie title title title","content,content,content,content,content"));
        list.add(new MessageItem(1,"titie title title title","content,content,content,content,content"));
        list.add(new MessageItem(1,"titie title title title","content,content,content,content,content"));
        list.add(new MessageItem(1,"titie title title title","content,content,content,content,content"));
        list.add(new MessageItem(1,"titie title title title","content,content,content,content,content"));
        list.add(new MessageItem(1,"titie title title title","content,content,content,content,content"));
        return list;
    }
}