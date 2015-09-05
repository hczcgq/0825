package com.lawyer.android.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.bean.OrderEntity;
import com.lawyer.android.util.AppUtils;

import java.util.List;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class OrderAdapter extends BaseAdapterHelpter<OrderEntity.OrdersEntity>{


    private Context context;

    private List<OrderEntity.OrdersEntity> datas;


    public OrderAdapter(Context context, List<OrderEntity.OrdersEntity> datas) {
        super(context, datas);
        this.context=context;
        this.datas=datas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderHelper holder = ViewHolderHelper.get(context, convertView,
                parent, R.layout.view_fragment_order_item, position);
        TextView orderNoTextView=holder.getView(R.id.orderNoTextView);
        TextView orderStatueTextView=holder.getView(R.id.orderStatueTextView);
        TextView productNameTextView=holder.getView(R.id.productNameTextView);
        TextView productPriceTextView=holder.getView(R.id.productPriceTextView);
        TextView createTimeTextView=holder.getView(R.id.createTimeTextView);

        OrderEntity.OrdersEntity entity=datas.get(position);
        orderNoTextView.setText(entity.getPayNo());
        if(entity.getOrderStatus().equals("NOT_BIND")){
            orderStatueTextView.setText("");
        }else if(entity.getOrderStatus().equals("NOT_PAY")){
            orderStatueTextView.setText("未支付");
        }
        productNameTextView.setText("产品名称："+entity.getProduct().getName());
        productPriceTextView.setText("产品金额："+entity.getProduct().getPrice());
        createTimeTextView.setText(AppUtils.formatLongToDate(entity.getCreateDate()));
        return holder.getConvertView();
    }
}
