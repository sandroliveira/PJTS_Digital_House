package excurioso.ag_al.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl(url);

        myWebView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = myWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
    }
}
