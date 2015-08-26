package com.lawyer.android.base;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lawyer.android.R;

/**
 * 标题栏控制器
 * 
 * @author chenguoquan
 * 
 */
public class HeaderBarView {
    public void onSetContentView(final Activity activity, int paramInt) {
        View mainView = activity.findViewById(R.id.main);
        if ((mainView != null) && ((mainView instanceof ViewGroup))) {
            ViewGroup viewGroup = (ViewGroup) mainView;
            RelativeLayout linearLayout = (RelativeLayout) LayoutInflater.from(
                    activity).inflate(R.layout.view_head, null);
            linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1,
                    (int) activity.getResources().getDimension(
                            R.dimen.header_height)));
            viewGroup.addView(linearLayout, 0);
        }
    }

    public void onSetContentView(final Activity activity, View mainView) {
        if ((mainView != null) && ((mainView instanceof ViewGroup))) {
            ViewGroup viewGroup = (ViewGroup) mainView;
            RelativeLayout linearLayout = (RelativeLayout) LayoutInflater.from(
                    activity).inflate(R.layout.view_head, null);
            linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1,
                    (int) activity.getResources().getDimension(
                            R.dimen.header_height)));
            viewGroup.addView(linearLayout, 0);
        }
    }

    /**
     * 设置标题
     * 
     * @param paramActivity
     * @param paramString
     */
    public void setTitle(Activity paramActivity, String paramString) {
        View localView = paramActivity.findViewById(R.id.headTitleTextView);
        if ((localView != null) && ((localView instanceof TextView)))
            ((TextView) localView).setText(paramString);
    }

    public void setTitle(Activity paramActivity, int paramString) {
        View localView = paramActivity.findViewById(R.id.headTitleTextView);
        if ((localView != null) && ((localView instanceof TextView)))
            ((TextView) localView).setText(paramString);
    }

    /**
     * 显示左边按钮并设置标题
     * 
     * @param paramActivity
     *
     */
    public void showLeftButton(Activity paramActivity) {
        View localView = paramActivity.findViewById(R.id.headLeftLayout);
        localView.setVisibility(View.VISIBLE);
    }

    /**
     * 显示右边边按钮并设置标题
     * 
     * @param paramActivity
     * @param paramString
     */
    public void showRightButton(Activity paramActivity, String paramString) {
        View localView = paramActivity.findViewById(R.id.headRightLayout);
        localView.setVisibility(View.VISIBLE);
        View localTextView = paramActivity.findViewById(R.id.headRightTextView);
        if ((localTextView != null) && ((localTextView instanceof TextView)))
            ((TextView) localTextView).setText(paramString);
    }


    /**
     * 隐藏左边按钮
     * @param paramActivity
     */
    public void HideLeftButton(Activity paramActivity) {
        View localView = paramActivity.findViewById(R.id.headLeftLayout);
        localView.setVisibility(View.GONE);

    }

    /**
     * 隐藏右边按钮
     * @param paramActivity
     */
    public void HideRightButton(Activity paramActivity) {
        View localView = paramActivity.findViewById(R.id.headRightLayout);
        localView.setVisibility(View.GONE);
        
    }
    
    /**
     * 设置左边的那个按钮点击的事件
     * 
     * @param activity
     */
    public void addLeftButtonClick(Activity activity,
            View.OnClickListener butOnClickListener) {
        View localView = activity.findViewById(R.id.headLeftLayout);
        localView.setOnClickListener(butOnClickListener);
        localView.setClickable(true);
    }

    /**
     * 设置右边的那个按钮点击的事件
     * 
     * @param activity
     */
    public void addRightButtonClick(Activity activity,
            View.OnClickListener butOnClickListener) {
        View localView = activity.findViewById(R.id.headRightLayout);
        localView.setOnClickListener(butOnClickListener);
        localView.setClickable(true);

    }

    /**
     * 设置左边标题背景
     * 
     * @param activity
     * @param resouece
     */
    public void setLeftButtonBack(Activity activity, int resouece) {
        View localView = activity.findViewById(R.id.headLeftImageView);
        localView.setBackgroundResource(resouece);
    }

    /**
     * 设置右边标题背景
     * 
     * @param activity
     * @param resouece
     */
    public void setRightButtonBack(Activity activity, int resouece) {
        View localView = activity.findViewById(R.id.headRightTextView);
        localView.setBackgroundResource(resouece);
    }
}
