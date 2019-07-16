package android.huyhuynh.apprss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class ReadAmazingActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_amazing);
        webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("datalink");
        String url = bundle.getString("linkrss");
        Toast.makeText(ReadAmazingActivity.this,url,Toast.LENGTH_LONG).show();
        webView.loadUrl(url);
    }
}
