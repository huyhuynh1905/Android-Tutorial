package android.huyhuynh.intentdataresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnEdit;
    TextView txtShow;
    final int REQUEST_CODE_EDIT = 19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EditActivity.class);
                startActivityForResult(intent,REQUEST_CODE_EDIT);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQUEST_CODE_EDIT && resultCode==RESULT_OK && data!=null){
            String text = data.getStringExtra("text");
            txtShow.setText(text);
        }
    }

    private void init() {
        btnEdit = findViewById(R.id.btnEdit);
        txtShow = findViewById(R.id.txtShow);
    }
}
