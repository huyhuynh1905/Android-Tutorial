package android.huyhuynh.noteappwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    WorkDatabase mWorkDatabase;
    Button btnAdd;
    EditText edtNotes;
    ListView lvNotes;
    List<Notes> arrNotes;
    AdapterNotes adapterNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //creatDataBase(); //Khởi tạo database ban đầu:
        init();
    }

    private void init() {
        btnAdd = findViewById(R.id.btnAdd);
        lvNotes = findViewById(R.id.lvNotes);
        edtNotes = findViewById(R.id.edtNotes);
        //
        arrNotes = new ArrayList<>();
        readDataBaseNotes();
        adapterNotes = new AdapterNotes(this,R.layout.item_list_notes,arrNotes);
        lvNotes.setAdapter(adapterNotes);


    }

    private void readDataBaseNotes() {
        mWorkDatabase = new WorkDatabase(this,"noteapp.sqlite",null,1);
        arrNotes.removeAll(arrNotes);
        Cursor cursor = mWorkDatabase.getData("Select * from Notes");
        while (cursor.moveToNext()){
            int key = cursor.getInt(0);
            String name = cursor.getString(1);
            arrNotes.add(new Notes(key,name));
        }
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
