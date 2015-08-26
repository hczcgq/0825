package com.lawyer.android.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.bean.MenuItem;

import java.util.List;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class MenuAdapter extends BaseAdapterHelpter<MenuItem>{


    private Context context;

    private List<MenuItem> datas;


    public MenuAdapter(Context context, List<MenuItem> datas) {
        super(context, datas);
        this.context=context;
        this.datas=datas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderHelper holder = ViewHolderHelper.get(context, convertView,
                parent, R.layout.view_menu_item, position);
        ImageView iconImageView=holder.getView(R.id.iconImageView);
        TextView nameTextView=holder.getView(R.id.nameTextView);
        MenuItem item=datas.get(position);
        iconImageView.setImageResource(item.getIcon());
        nameTextView.setText(item.getName());
        return holder.getConvertView();
    }
}
