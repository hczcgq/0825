package com.lawyer.android.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

import com.lawyer.android.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class BaseUIActivity extends Activity {

    protected HeaderBarView mHeaderBar;
    protected DisplayImageOptions options;        // DisplayImageOptions是用于设置图片显示的类


    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        mHeaderBar = new HeaderBarView();
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        options = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.usericon)          // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.usericon)  // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.usericon)       // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)                          // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(20))  // 设置成圆角图片
                .build();                                   // 创建配置过得DisplayImageOption对象
    }

    /**
     * 设置该页面的布局文件
     */
    public void setContentView(int paramInt) {
        super.setContentView(paramInt);
        mHeaderBar.onSetContentView(this, paramInt);
    }

    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        mHeaderBar.onSetContentView(this, view);
    }

    /**
     * 显示标题栏左边按钮
     * 
     */
    public void showLeftButton() {
        mHeaderBar.showLeftButton(this);
    }

    /**
     * 显示标题栏右边按钮
     * 
     * @param text
     */
    public void showRightButton(String text) {
        mHeaderBar.showRightButton(this, text);
    }

    /**
     * 隐藏左边按钮
     *
     */
    public void HideLeftButton() {
        mHeaderBar.HideLeftButton(this);
    }

    /**
     * 隐藏右边按钮
     * 
     */
    public void HideRightButton() {
        mHeaderBar.HideRightButton(this);
    }



    /**
     * 设置左边按钮的背景
     * 
     * @param resource
     */
    public void setLeftButtonBackground(int resource) {
        mHeaderBar.setLeftButtonBack(this, resource);
    }

    /**
     * 设置右边按钮的背景
     * 
     * @param resource
     */
    public void setRightButtonBackground(int resource) {
        mHeaderBar.setRightButtonBack(this, resource);
    }

    /**
     * 设置左边监听事件
     * 
     * @param onClickListener
     */
    public void addLeftButtonClick(View.OnClickListener onClickListener) {
        mHeaderBar.addLeftButtonClick(this, onClickListener);
    }

    /**
     * 设置右边监听事件
     * 
     * @param onClickListener
     */
    public void addRightButtonClick(View.OnClickListener onClickListener) {
        mHeaderBar.addRightButtonClick(this, onClickListener);
    }

    /**
     * 设置标题
     * 
     * @param paramString
     */
    public void setHeadTitle(String paramString) {
        mHeaderBar.setTitle(this, paramString);
    }

    public void setHeadTitle(int paramString) {
        mHeaderBar.setTitle(this, paramString);
    }




    @Override
    protected void onResume() {
        super.onResume();
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
