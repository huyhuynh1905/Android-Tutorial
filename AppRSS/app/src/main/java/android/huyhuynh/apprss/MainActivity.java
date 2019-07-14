package android.huyhuynh.apprss;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

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
    Bitmap imgAnh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intit();
        new LoadRss().execute("https://vnexpress.net/rss/so-hoa.rss");
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
            StringBuilder linkss = new StringBuilder("Toast: ");
            for (int i=1;i<node.getLength();i++){
                Element element = (Element) node.item(i);
                String tieude = parser.getValue(element,"title");
                String link = parser.getValue(element,"link");
                //
                NodeList nd = element.getElementsByTagName("description");
                Element element1 = (Element) nd.item(0);
                String linkStr = parser.getCharacterDataFromElement(element1);
                String content = readContent(linkStr);
                //
                Bitmap bitmapAnh = loadAnh(readLinkAnh(linkStr));
                Express express = new Express(tieude,bitmapAnh,content,link);
                Log.d("PIC","A - "+loadAnh(readLinkAnh(linkStr)));
                arrEx.add(express);
            }
            adapterEx.notifyDataSetChanged();
        }
        public String readLinkAnh(String linkStr){
            String link="";
            link = linkStr.substring(linkStr.indexOf("original=\"")+10,linkStr.lastIndexOf("\" >"));
            return link;
        }
        public String readContent(String linkStr1){
            String content1="";
            content1 = linkStr1.substring(linkStr1.lastIndexOf("</br>")+5,linkStr1.lastIndexOf("."));
            return content1;
        }
        private Bitmap loadAnh(String linkImg){
            try {
                URL url = new URL(linkImg);
                InputStream inputStream = url.openConnection().getInputStream();
                Bitmap bm = BitmapFactory.decodeStream(inputStream);
                return bm;
            } catch (Exception e) {
                return null;
            }
        }
    }



    public class LoadImage extends AsyncTask<String,Bitmap,Bitmap>{
        Bitmap bm;
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                bm = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bm;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgAnh = bitmap;
        }
    }
}
