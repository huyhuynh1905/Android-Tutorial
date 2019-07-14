package android.huyhuynh.apprss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
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

    }

    private void intit() {
        lvRss = findViewById(R.id.lvRss);
        arrEx = new ArrayList<>();
        adapterEx = new ExpressAdapter(MainActivity.this,R.layout.list_custom_rss,arrEx);
        lvRss.setAdapter(adapterEx);
    }

    private class LoadRss extends AsyncTask<String,Void,String>{
        StringBuilder rss = new StringBuilder("");
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line=br.readLine())!=null){
                    rss.append(line+"\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rss.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList node = document.getElementsByTagName("item");
            for (int i=0;i<node.getLength();i++){
                Element element = (Element) node.item(i);
                String tieude = parser.getValue(element,"title");
                String link = parser.getValue(element,"link");
                String content = parser.getValue(element,"")
            }
        }
    }
}
