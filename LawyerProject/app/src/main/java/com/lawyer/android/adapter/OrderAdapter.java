package com.lawyer.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.activity.UserActivity;
import com.lawyer.android.bean.OrderEntity;
import com.lawyer.android.util.AppUtils;
import com.lawyer.android.util.StringUtils;

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
        TextView userNameTextView=holder.getView(R.id.userNameTextView);
        TextView mobileTextView=holder.getView(R.id.mobileTextView);
        TextView productNameTextView=holder.getView(R.id.productNameTextView);
        TextView productPriceTextView=holder.getView(R.id.productPriceTextView);
        TextView createTimeTextView=holder.getView(R.id.createTimeTextView);
        TextView validTimeTextView=holder.getView(R.id.validTimeTextView);
        TextView companyTextView=holder.getView(R.id.companyTextView);

        final OrderEntity.OrdersEntity entity=datas.get(position);
        orderNoTextView.setText(entity.getPayNo());
        if(!StringUtils.isEmpty(entity.getUser().getNickname())) {
            userNameTextView.setText("昵称：" + entity.getUser().getNickname());
        }
        mobileTextView.setText(entity.getUser().getMobile());
        productNameTextView.setText("产品名称："+entity.getProduct().getName());
        productPriceTextView.setText("产品金额："+entity.getProduct().getPrice());
        createTimeTextView.setText("订单时间："+AppUtils.getDateFromString(entity.getCreateDate()));
        validTimeTextView.setText("有效期：" + AppUtils.getDateFromString(entity.getCreateDate()) + "至" + AppUtils.getDateFromString(entity.getCreateDate(), 1));

        if(entity.getProduct().getName().equals("千元聘法顾")){
            companyTextView.setVisibility(View.VISIBLE);
            companyTextView.setText("公司："+entity.getCompanyName());
        }else{
            companyTextView.setVisibility(View.GONE);
        }

        userNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("User", entity.getUser());
                context.startActivity(intent);
            }
        });
        mobileTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + entity.getUser().getMobile()));
                context.startActivity(intent);
            }
        });

        return holder.getConvertView();
    }
}
