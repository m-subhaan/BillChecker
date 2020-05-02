package com.nopalyer.navigationdrawer;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {


    public WebViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ProgressBar progressBar;

        View v= inflater.inflate(R.layout.fragment_web_view, container, false);
       WebView w1 = (WebView) v.findViewById(R.id.webView);
       progressBar=(ProgressBar)v.findViewById(R.id.pro);

        WebSettings webSettings= w1.getSettings();
        w1.getSettings().setJavaScriptEnabled(true);

        w1.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
                if(newProgress==100)
                {
                    progressBar.setVisibility(view.GONE);
                }
            }
        });
        String link=getArguments().getString("url");

        w1.loadUrl(link);
        return v;

    }
}
