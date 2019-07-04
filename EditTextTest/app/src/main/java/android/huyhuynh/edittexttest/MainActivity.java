package android.huyhuynh.edittexttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnShow;
    EditText edtName;
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        control();
    }

    private void control() {
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                txtShow.setText(name);
            }
        });
        btnShow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String name = edtName.getText().toString();
                Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    private void init() {
        txtShow = findViewById(R.id.txtShow);
        btnShow = findViewById(R.id.btnShow);
        edtName = findViewById(R.id.edtName);
    }
}
