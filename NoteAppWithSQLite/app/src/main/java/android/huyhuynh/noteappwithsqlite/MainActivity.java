package android.huyhuynh.noteappwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
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
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNotesToDatabase();
            }
        });
    }

    //thêm
    private void addNotesToDatabase() {
        String note = edtNotes.getText().toString().trim();
        if (note.length()!=0){
            String insert = "INSERT INTO Notes VALUES(null,\""+note+"\")";
            mWorkDatabase.queryData(insert);
            readDataBaseNotes();
            adapterNotes.notifyDataSetChanged();
        } else {
            Toast.makeText(MainActivity.this,"Nhập notes đầy đủ!",Toast.LENGTH_SHORT).show();
        }
    }

    //Sửa
    public void editNotesToDatabase(String name, final int key){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_edit_notes);
        dialog.show();
        Button btnCancel = dialog.findViewById(R.id.btnCancel);
        Button btnEdit = dialog.findViewById(R.id.btnEdit);
        final EditText edtEdit = dialog.findViewById(R.id.edtEdit);

        edtEdit.setText(name);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = edtEdit.getText().toString().trim();
                if (note.length()!=0){
                    String sql = "update Notes set NAMENOTE = \""+note+"\" where ID = "+key;
                    mWorkDatabase.queryData(sql);
                    readDataBaseNotes();
                    adapterNotes.notifyDataSetChanged();
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this,"Nhập notes đầy đủ!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    //Xoá
    public void delNotesDatabase(final int key){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Item");
        builder.setMessage("Do you want delete this item?");
        builder.setIcon(R.drawable.del);
        builder.setCancelable(false); //ko cho bấm ngoài dia log
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String sql = "delete from Notes where ID = "+key;
                mWorkDatabase.queryData(sql);
                readDataBaseNotes();
                adapterNotes.notifyDataSetChanged();
            }
        });
        builder.show();
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
