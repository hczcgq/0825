package com.lawyer.android.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.bean.ToolEntity;

import java.util.List;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class ToolAdapter extends BaseAdapterHelpter<ToolEntity>{


    private Context context;

    private List<ToolEntity> datas;


    public ToolAdapter(Context context, List<ToolEntity> datas) {
        super(context, datas);
        this.context=context;
        this.datas=datas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderHelper holder = ViewHolderHelper.get(context, convertView,
                parent, R.layout.view_fragment_tool_item, position);
        ImageView iconImageView=holder.getView(R.id.iconImageView);
        TextView nameTextView=holder.getView(R.id.nameTextView);
        TextView messageTextView=holder.getView(R.id.messageTextView);
        ToolEntity item=datas.get(position);
        iconImageView.setImageResource(item.getIcon());
        nameTextView.setText(item.getName());
        messageTextView.setText(item.getMessage());
        return holder.getConvertView();
    }
}
