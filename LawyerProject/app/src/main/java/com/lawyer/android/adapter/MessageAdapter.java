package com.lawyer.android.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.bean.MessageEntity;

import java.util.List;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class MessageAdapter extends BaseAdapterHelpter<MessageEntity>{


    private Context context;

    private List<MessageEntity> datas;


    public MessageAdapter(Context context, List<MessageEntity> datas) {
        super(context, datas);
        this.context=context;
        this.datas=datas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderHelper holder = ViewHolderHelper.get(context, convertView,
                parent, R.layout.view_fragment_message_item, position);
        TextView titleTextView=holder.getView(R.id.titleTextView);
        TextView contentTextView=holder.getView(R.id.contentTextView);
        MessageEntity item=datas.get(position);
        titleTextView.setText(item.getTitle());
        contentTextView.setText(item.getContent());
        return holder.getConvertView();
    }
}
