package com.lawyer.android.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lawyer.android.R;

import java.util.List;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class AboutAdapter extends BaseAdapterHelpter<String>{


    private Context context;

    private List<String> datas;


    public AboutAdapter(Context context, List<String> datas) {
        super(context, datas);
        this.context=context;
        this.datas=datas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderHelper holder = ViewHolderHelper.get(context, convertView,
                parent, R.layout.view_fragment_about_item, position);
        TextView nameTextView=holder.getView(R.id.nameTextView);
        nameTextView.setText(datas.get(position));
        return holder.getConvertView();
    }
}
