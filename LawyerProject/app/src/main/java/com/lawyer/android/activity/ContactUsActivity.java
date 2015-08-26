package com.lawyer.android.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class ContactUsActivity extends BaseUIActivity{

    private TextView webSiteTextView;
    private TextView mobileTextView;


    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_contact_us);
        initView();
    }

    private void initView(){
        setHeadTitle(R.string.contact_us);
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        webSiteTextView= (TextView) findViewById(R.id.webSiteTextView);
        mobileTextView= (TextView) findViewById(R.id.mobileTextView);
        webSiteTextView.setText(Html.fromHtml(getWebsite()));
        mobileTextView.setText(Html.fromHtml(getMobile()));
    }

    private String getWebsite(){
        String html="网站：<u><font color=\"#70B1B5\">http://www.shuofatang.com</font></u>";
        return html;
    }

    private String getMobile(){
        String html="电话：<u><font color=\"#70B1B5\">021-20228283</font></u>";
        return html;
    }
}

