package com.lawyer.android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lawyer.android.R;
import com.lawyer.android.activity.ContactUsActivity;
import com.lawyer.android.adapter.AboutAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class FragmentAboutUs extends Fragment {
    private ListView mListView;

    private String[] aboutItems;

    private Intent intent;

    public FragmentAboutUs() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_fragment_about, null);
        mListView = (ListView) view.findViewById(R.id.aboutListView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }

    private void initDate(){
        aboutItems=getActivity().getResources().getStringArray(R.array.about_items);
        List<String> items= Arrays.asList(aboutItems);
        mListView.setAdapter(new AboutAdapter(getActivity(),items));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        //点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    intent=new Intent(getActivity(),ContactUsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}