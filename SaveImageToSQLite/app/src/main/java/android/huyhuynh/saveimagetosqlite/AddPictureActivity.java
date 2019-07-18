package android.huyhuynh.saveimagetosqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddPictureActivity extends AppCompatActivity {
    ImageButton btnCamera, btnFolder;
    ImageView imgView;
    EditText edtName, edtInfo;

    int REQUEST_CODE_CAM = 19;
    int REQUEST_CODE_FOLDER = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picture);
        init();
        control();
    }

    private void control() {
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                importImageDromCamera();
            }
        });
        btnFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                importImageFromFolder();
            }
        });
    }

    //Thêm ảnh từ thư viện có sẵn trong máy
    private void importImageFromFolder() {
        Intent intentfolder = new Intent(Intent.ACTION_PICK);
        intentfolder.setType("image/*");
        startActivityForResult(intentfolder,REQUEST_CODE_FOLDER);
    }

    //Thêm ảnh từ camera
    private void importImageDromCamera() {
        Intent intentcam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentcam,REQUEST_CODE_CAM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //Nhận ảnh từ máy ảnh
        if (requestCode == REQUEST_CODE_CAM && resultCode == RESULT_OK && data!=null){
            Bitmap bm = (Bitmap) data.getExtras().get("data");
            imgView.setImageBitmap(bm);
        }
        //Nhận ảnh từ folder
        if (requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data!=null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bm = BitmapFactory.decodeStream(inputStream);
                imgView.setImageBitmap(bm);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void init() {
        btnCamera = findViewById(R.id.btnCamera);
        btnFolder = findViewById(R.id.btnFolder);
        imgView = findViewById(R.id.imgView);
        edtName = findViewById(R.id.edtName);
        edtInfo = findViewById(R.id.edtInfo);
    }
}
