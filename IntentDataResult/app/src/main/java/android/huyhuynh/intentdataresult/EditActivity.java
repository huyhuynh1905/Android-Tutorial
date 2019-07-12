package android.huyhuynh.intentdataresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    Button btnConfirm;
    EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        init();
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtText.getText().toString().trim();
                if (text.length()==0){
                    Toast.makeText(EditActivity.this,"Please enter your text",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("text",text);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    private void init() {
        btnConfirm = findViewById(R.id.btnConfirm);
        edtText = findViewById(R.id.edtText);
    }
}
