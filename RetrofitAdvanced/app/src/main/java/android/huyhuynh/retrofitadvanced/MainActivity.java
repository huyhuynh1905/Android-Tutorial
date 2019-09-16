package android.huyhuynh.retrofitadvanced;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.huyhuynh.retrofitadvanced.retrofit2.APIUltils;
import android.huyhuynh.retrofitadvanced.retrofit2.DataClient;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnChonAnh, btnSend, btnLoad;
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
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upLoadImage();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadListMenu();
            }
        });
    }

    private void loadListMenu() {
        DataClient dataClient = APIUltils.getDataClient();
        Call<List<Menu>> callBack = dataClient.getListMenu("MB01");
        callBack.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                List<Menu> arrMenuTest = new ArrayList<>();
                arrMenuTest = response.body();
                arrMenu.clear();
                for (Menu mn : arrMenuTest){
                    Log.d("AAA", mn.getTenThucUong() +" - "+ mn.getHinhAnh());
                    Menu menu = new Menu(mn.getMaThucUong(),mn.getTenThucUong(),
                            mn.getDonGia(),mn.getHinhAnh(),mn.getGhiChu());
                    arrMenu.add(menu);
                }
                mMenuAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void init() {
        btnChonAnh = findViewById(R.id.btnChonAnh);
        imgAnh = findViewById(R.id.imgAnh);
        lvMenu = findViewById(R.id.lvMenu);
        btnSend = findViewById(R.id.btnSend);
        btnLoad = findViewById(R.id.btnLoad);
        //Load dữ liệu
        arrMenu = new ArrayList<>();
        //String maThucUong, String tenThucUong, Double donGia, String hinhAnh, String ghiChu
        arrMenu.add(new Menu("","Nước Dừa",120,
                "http://192.168.1.102:86/ordercoffee/image/water.png",""));
        arrMenu.add(new Menu("","Trà Đào",120,
                "http://192.168.1.102:86/ordercoffee/image/water.png",""));
        arrMenu.add(new Menu("","Trà Chanh",120,
                "http://192.168.1.102:86/ordercoffee/image/water.png",""));
        mMenuAdapter = new MenuAdapter(this,R.layout.item_menu,arrMenu);
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
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        Log.d("Message", "upLoadImage: "+file_path);
        MultipartBody.Part body = MultipartBody.Part.createFormData("imageFile",file_path,requestBody);
        DataClient dataClient = APIUltils.getDataClient();
        Call<String> callback = dataClient.UploadPhoto(body);
        callback.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response!=null){
                    String message = response.body();
                    Log.d("Message",message);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("Message", "onFailure: "+t.getMessage());
                t.printStackTrace();
            }
        });
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
