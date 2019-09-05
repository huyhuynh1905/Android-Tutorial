package android.huyhuynh.retrofitadvanced;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnChonAnh;
    ImageView imgAnh;
    ListView lvMenu;
    MenuAdapter mMenuAdapter;
    List<Menu> arrMenu;

    String realPath = "";
    final int REQUEST_IMG = 19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnChonAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_IMG);
            }
        });

    }

    private void init() {
        btnChonAnh = findViewById(R.id.btnChonAnh);
        imgAnh = findViewById(R.id.imgAnh);
        lvMenu = findViewById(R.id.lvMenu);
        arrMenu = new ArrayList<>();
        mMenuAdapter = new MenuAdapter(MainActivity.this,R.layout.item_menu,arrMenu);
        lvMenu.setAdapter(mMenuAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMG && resultCode == RESULT_OK && data!=null){
            Uri uri = data.getData();
            realPath = getRealPathFromURI(uri);
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgAnh.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void upLoadImage(){
        File file = new File(realPath);
        String file_path = file.getAbsolutePath();
        String[] arrTenFile = file_path.split("\\.");
        file_path = arrTenFile[0] + System.currentTimeMillis() + "." + arrTenFile[1];
    }

    public String getRealPathFromURI (Uri contentUri) {
        String path = null;
        String[] proj = { MediaStore.MediaColumns.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }
}
