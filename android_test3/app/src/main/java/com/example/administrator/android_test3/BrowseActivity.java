package com.example.administrator.android_test3;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by 陌年 on 2017/12/24.
 */

public class BrowseActivity extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        if(TextUtils.isEmpty(url)) {
            url = "http://www.baidu.com ";
        }
        WebView webView = (WebView) findViewById(R.id.mywebview);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(url);
    }
}
