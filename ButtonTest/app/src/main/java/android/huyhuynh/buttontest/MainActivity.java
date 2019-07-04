package android.huyhuynh.buttontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtShowMess;
    Button btnClickme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtShowMess = findViewById(R.id.txtShow);
        btnClickme = findViewById(R.id.btnClick);

        btnClickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtShowMess.setText("One Click!");
            }
        });
        btnClickme.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                txtShowMess.setText("Long Click!");
                return false;
            }
        });
    }
}
