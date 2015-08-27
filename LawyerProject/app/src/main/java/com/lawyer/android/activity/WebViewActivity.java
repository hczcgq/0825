package com.lawyer.android.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;
import com.lawyer.android.bean.ToolItem;
import com.lawyer.android.util.LoadingDialog;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class WebViewActivity extends BaseUIActivity{

    private ToolItem item;
    private WebView webView;

    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_webview);


        webView = (WebView) findViewById(R.id.helpWebView);
        mLoadingDialog = new LoadingDialog(this);

        item= (ToolItem) getIntent().getSerializableExtra("item");
        if(item!=null){
            setHeadTitle(item.getName());
            showWebView(item.getUrl());
        }
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();;
            }
        });


    }

    private void showWebView(String url) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        if (Build.VERSION.SDK_INT >= 19) {
            webView.getSettings().setCacheMode(
                    WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mLoadingDialog.dismiss();
                } else {
                    mLoadingDialog.dialogShow();
                }
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
    }
}
