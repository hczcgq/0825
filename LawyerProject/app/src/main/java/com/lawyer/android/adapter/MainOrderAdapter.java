package com.lawyer.android.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.bean.OrderEntity;
import com.lawyer.android.util.AppUtils;

import java.util.List;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class MainOrderAdapter extends BaseAdapterHelpter<OrderEntity.OrdersEntity>{


    private Context context;

    private List<OrderEntity.OrdersEntity> datas;


    public MainOrderAdapter(Context context, List<OrderEntity.OrdersEntity> datas) {
        super(context, datas);
        this.context=context;
        this.datas=datas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderHelper holder = ViewHolderHelper.get(context, convertView,
                parent, R.layout.view_fragment_main_item, position);
        TextView orderNoTextView=holder.getView(R.id.orderNoTextView);
        TextView productNameTextView=holder.getView(R.id.productNameTextView);
        TextView productPriceTextView=holder.getView(R.id.productPriceTextView);
        TextView createTimeTextView=holder.getView(R.id.createTimeTextView);
        Button DetailButton=holder.getView(R.id.DetailButton);
        Button orderButton=holder.getView(R.id.orderButton);

        final OrderEntity.OrdersEntity entity=datas.get(position);
        orderNoTextView.setText(entity.getPayNo());
        productNameTextView.setText("产品名称：" + entity.getProduct().getName());
        productPriceTextView.setText("产品金额："+entity.getProduct().getPrice());
        createTimeTextView.setText(AppUtils.getDateFromString(entity.getCreateDate()));

        DetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDetail(entity.getId());
            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOrder(entity.getId());
            }
        });

        return holder.getConvertView();
    }


    private OrderListener listener;
    public void setOrderListener(OrderListener listener){
        this.listener=listener;
    }

    public interface OrderListener{
        public void onDetail(int no);
        public void onOrder(int no);
    }
}
