package android.huyhuynh.asynctaskexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        txtShow = findViewById(R.id.txtShow);

        //sorry ^^
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ProgressExample().execute();
            }
        });


    }

    private class ProgressExample extends AsyncTask<Void,String,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Start Pre
            txtShow.setText("Start progress...\n");
        }

        @Override
        protected String doInBackground(Void... voids) {
            String end = "End progress!";

            for (int i=0;i<5;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("Progress "+i+"\n");
            }

            return end;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtShow.append(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //s is end re turn
            txtShow.append(s);
        }
    }
}
