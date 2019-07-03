package android.huyhuynh.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtChap2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtChap2 =findViewById(R.id.txtChapp2);
        txtChap2.setText("Click");
        txtChap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtChap2.setText("HCode");
            }
        });

    }
}
