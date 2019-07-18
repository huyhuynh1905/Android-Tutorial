package android.huyhuynh.saveimagetosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    ListView lvImg;
    List<ImageClass> arrImg;
    AdapterImage adapterImg;
    public static DatabaseImageWorker databaseImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        control();
    }

    private void control() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddPictureActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        btnAdd = findViewById(R.id.btnAdd);
        lvImg = findViewById(R.id.lvImg);
        arrImg = new ArrayList<>();
        adapterImg = new AdapterImage(this,R.layout.layout_item_image,arrImg);
        lvImg.setAdapter(adapterImg);
        createDatabase();
        getDatabaseImage();
    }
    //khởi tạo database
    public void createDatabase(){
        databaseImage = new DatabaseImageWorker(this,"saveimage.sqlite",null,1);
        String create = "CREATE TABLE IF NOT EXISTS Images (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME NVARCHAR(20), INFO NVARCHA(50), PICTURE BLOB)";
        databaseImage.queryData(create);
    }
    //select database
    public void getDatabaseImage(){
        String sql = "select * from Images";
        Cursor cursor = databaseImage.getData(sql);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String info = cursor.getString(2);
            byte[] pic = cursor.getBlob(3);
            arrImg.add(new ImageClass(id,name,info,pic));
        }
        adapterImg.notifyDataSetChanged();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getDatabaseImage();
    }
}
