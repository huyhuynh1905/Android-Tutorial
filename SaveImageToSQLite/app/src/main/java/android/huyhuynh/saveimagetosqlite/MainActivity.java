package android.huyhuynh.saveimagetosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
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
        createDatabase();
    }
    //khởi tạo database
    public void createDatabase(){
        databaseImage = new DatabaseImageWorker(this,"saveimage.sqlite",null,1);
        String create = "CREATE TABLE IF NOT EXISTS Images (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME NVARCHAR(20), INFO NVARCHA(50), PICTURE BLOB)";
        databaseImage.queryData(create);
    }
}
