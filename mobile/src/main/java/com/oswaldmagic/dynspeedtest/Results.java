package com.oswaldmagic.dynspeedtest;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Stefan Oswald on 7/7/2014.
 */
public class Results extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://dnstest.dyn.com/");
    }

}
