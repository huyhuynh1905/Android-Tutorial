package android.huyhuynh.noteappwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WorkDatabase mWorkDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //creatDataBase(); //Khởi tạo database ban đầu:
        init();
    }

    private void init() {
    }

    private void creatDataBase() {
        //Tạo database
        mWorkDatabase = new WorkDatabase(this,"noteapp.sqlite",null,1);
        String taoBang = "CREATE TABLE IF NOT EXISTS Notes(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAMENOTE VCHAR(200))";
        mWorkDatabase.queryData(taoBang);
        String insert = "INSERT INTO Notes VALUES(null,\"Đi Ngủ Đúng Giờ\")";
        //mWorkDatabase.queryData(insert);
        Cursor cursor = mWorkDatabase.getData("Select * from Notes");
        while (cursor.moveToNext()){
            String name = cursor.getString(1);
            Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
        }

    }
}
