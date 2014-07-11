package com.oswaldmagic.dynspeedtest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan Oswald on 7/7/2014.
 */
public class DynSpeedTest extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domain_lookup);

        // initialize the buttons
        Button results = (Button) findViewById(R.id.results);
        Button domainlookup = (Button) findViewById(R.id.search);


        // when buttons are clicked
        results.setOnClickListener(this);
        domainlookup.setOnClickListener(this);

    }

    private void resultsClick()
    {
        startActivity(new Intent("com.oswaldmagic.dynspeedtest.History"));
    }

    private void domainClick()
    {
        startActivity(new Intent("com.oswaldmagic.dynspeedtest.Domain"));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.results:
                resultsClick();
                break;
            case R.id.search:
                domainClick();
                break;
        }
    }

    public void postData(){
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://dnstest.dyn.com/");

        try {
            // Add your data
            List<NameValuePair> pairs = new ArrayList<NameValuePair>(3);
            pairs.add(new BasicNameValuePair("domain", "oswaldmagic.com"));
            pairs.add(new BasicNameValuePair("sendReportTo", "stefanpauloswald@gmail.com"));
            pairs.add(new BasicNameValuePair("mobile", "1"));
            httppost.setEntity(new UrlEncodedFormEntity(pairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }

}
