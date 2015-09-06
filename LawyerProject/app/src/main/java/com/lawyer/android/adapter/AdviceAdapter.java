package com.lawyer.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.activity.UserActivity;
import com.lawyer.android.bean.AdviceEntity;
import com.lawyer.android.util.AppUtils;

import java.util.List;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class AdviceAdapter extends BaseAdapterHelpter<AdviceEntity.ConsultsEntity> {


    private Context context;

    private List<AdviceEntity.ConsultsEntity> datas;


    public AdviceAdapter(Context context, List<AdviceEntity.ConsultsEntity> datas) {
        super(context, datas);
        this.context = context;
        this.datas = datas;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        ViewHolderHelper holder = ViewHolderHelper.get(context, convertView,
                parent, R.layout.view_fragment_advice_item, position);
        TextView orderNoTextView = holder.getView(R.id.orderNoTextView);
        TextView userNameTextView = holder.getView(R.id.userNameTextView);
        TextView mobileTextView = holder.getView(R.id.mobileTextView);
        TextView lawyerQuestionBigTextView = holder.getView(R.id.lawyerQuestionBigTextView);
        TextView lawyerQuestionSmallTextView = holder.getView(R.id.lawyerQuestionSmallTextView);
        TextView createTimeTextView = holder.getView(R.id.createTimeTextView);

        final AdviceEntity.ConsultsEntity entity = datas.get(position);
        orderNoTextView.setText("咨询订单号：" + entity.getId());
        userNameTextView.setText("昵称：" + entity.getUser().getName());
        mobileTextView.setText(entity.getUser().getMobile());
        lawyerQuestionBigTextView.setText("法律问题大类：" + entity.getCategory().getParent().getName());
        lawyerQuestionSmallTextView.setText("法律问题小类：" + entity.getCategory().getName());
        createTimeTextView.setText(AppUtils.formatLongToDate(entity.getCreateDate()));

        userNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("User", entity.getUser());
                context.startActivity(intent);
            }
        });
        return holder.getConvertView();
    }
}
