package android.huyhuynh.asynctaskloadimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btnLoad;
    EditText edtUrl;
    ImageView imgPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoad = findViewById(R.id.btnLoadImage);
        edtUrl = findViewById(R.id.edtUrl);
        imgPic = findViewById(R.id.imgPic);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = edtUrl.getText().toString().trim();
                new LoadImageFromInternet().execute(url);
            }
        });


    }
    private class LoadImageFromInternet extends AsyncTask<String,Void, Bitmap>{
        Bitmap img = null;
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                img = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return img;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgPic.setImageBitmap(bitmap);
        }
    }
}
