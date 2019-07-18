package android.huyhuynh.saveimagetosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class AddPictureActivity extends AppCompatActivity {
    ImageButton btnCamera, btnFolder;
    ImageView imgView;
    EditText edtName, edtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picture);
        init();
    }

    private void init() {
        btnCamera = findViewById(R.id.btnCamera);
        btnFolder = findViewById(R.id.btnFolder);
        imgView = findViewById(R.id.imgView);
        edtName = findViewById(R.id.edtName);
        edtInfo = findViewById(R.id.edtInfo);
    }
}
