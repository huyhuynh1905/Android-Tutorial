package android.huyhuynh.apprss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvRss;
    List<Express> arrEx;
    ExpressAdapter adapterEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intit();
        control();
    }

    private void control() {
        lvRss.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ReadAmazingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("linkrss",arrEx.get(i).getLink());
                intent.putExtra("datalink",bundle);
                startActivity(intent);
                return false;
            }
        });
    }

    private void intit() {
        lvRss = findViewById(R.id.lvRss);
        arrEx = new ArrayList<>();
        adapterEx = new ExpressAdapter(MainActivity.this, R.layout.list_custom_rss, arrEx);
        lvRss.setAdapter(adapterEx);
        new LoadRss().execute("https://vnexpress.net/rss/so-hoa.rss");
    }

    private class LoadRss extends AsyncTask<String, Void, String> {
        StringBuilder rss = new StringBuilder("");

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = br.readLine()) != null) {
                    rss.append(line + "\n");
                }
                br.close();
                XMLDOMParser parser = new XMLDOMParser();
                Document document = parser.getDocument(rss.toString());
                NodeList node = document.getElementsByTagName("item");
                for (int i = 1; i < node.getLength(); i++) {
                    Element element = (Element) node.item(i);
                    String tieude = parser.getValue(element, "title");
                    String link = parser.getValue(element, "link");
                    //
                    NodeList nd = element.getElementsByTagName("description");
                    Element element1 = (Element) nd.item(0);
                    String linkStr = parser.getCharacterDataFromElement(element1);
                    String content = readContent(linkStr);
                    //
                    Bitmap bitmapAnh = null;
                    try {
                        bitmapAnh = Picasso.with(MainActivity.this).load(readLinkAnh(linkStr)).get();
                        Log.d("PPP", "onPostExecute: " + bitmapAnh);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Express express = new Express(tieude, bitmapAnh, content, link);
                    arrEx.add(express);
                }
                adapterEx.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rss.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

        }

        public String readLinkAnh(String linkStr) {
            String link = "";
            link = linkStr.substring(linkStr.indexOf("original=\"") + 10, linkStr.lastIndexOf("\" >"));
            return link;
        }

        public String readContent(String linkStr1) {
            String content1 = "";
            content1 = linkStr1.substring(linkStr1.lastIndexOf("</br>") + 5, linkStr1.lastIndexOf("."));
            return content1;
        }
    }
}
