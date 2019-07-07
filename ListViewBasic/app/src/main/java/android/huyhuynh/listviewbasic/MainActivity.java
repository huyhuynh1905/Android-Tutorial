package android.huyhuynh.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewColor;
    EditText edtText;
    Button btnAdd, btnDel, btnEdit;
    List<String> mColor;
    ArrayAdapter<String> arrAdapterColor;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        init();
        //
        control();

    }

    private void control() {
        startListView();
        //Event on item
        listViewColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String col = mColor.get(i);
                edtText.setText(col);
                index = i;
            }
        });
        //Add item
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addStr = edtText.getText().toString().trim();
                if (addStr.length()!=0){
                    mColor.add(addStr);
                    arrAdapterColor.notifyDataSetChanged();
                    edtText.setText("");
                } else {
                    Toast.makeText(MainActivity.this,"Please enter your text!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Delete item
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index!=-1) {
                    mColor.remove(index);
                    arrAdapterColor.notifyDataSetChanged();
                    index=-1;
                } else {
                    Toast.makeText(MainActivity.this,"Please enter your item delete!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        //edit
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index!=-1){
                    String edtStr = edtText.getText().toString().trim();
                    if (edtStr.length()!=0) {
                        mColor.set(index, edtStr);
                        arrAdapterColor.notifyDataSetChanged();
                        edtText.setText("");
                    } else {
                        Toast.makeText(MainActivity.this,"Please enter your item text edit!",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this,"Please enter your item editer!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void init() {
        listViewColor = findViewById(R.id.listViewColor);
        btnAdd = findViewById(R.id.btnAdd);
        btnDel = findViewById(R.id.btnDel);
        btnEdit = findViewById(R.id.btnEdit);
        edtText = findViewById(R.id.edtText);
    }

    private void startListView(){
        mColor = new ArrayList<>();
        mColor.add("Blue");
        mColor.add("Red");
        mColor.add("Green");
        mColor.add("Black");
        mColor.add("White");
        arrAdapterColor = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,
                mColor);
        listViewColor.setAdapter(arrAdapterColor);
    }
}
