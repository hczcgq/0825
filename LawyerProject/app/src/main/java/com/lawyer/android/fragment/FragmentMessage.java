package com.lawyer.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lawyer.android.R;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class FragmentMessage extends Fragment {
    TextView textView;

    public FragmentMessage() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_fragment_main, null);

        textView = (TextView) view.findViewById(R.id.fragment_main_textview);

        return view;
    }
}