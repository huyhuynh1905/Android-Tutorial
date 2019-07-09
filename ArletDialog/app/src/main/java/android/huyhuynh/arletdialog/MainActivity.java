package android.huyhuynh.arletdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<String> arrName;
    ArrayAdapter adapterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        control();
    }

    private void control() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                acceptDelete(i);
                return false;
            }
        });
    }

    private void acceptDelete(final int index) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Delete Item");
        alert.setMessage("Do you want del this item?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrName.remove(index);
                adapterName.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Delete item",Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"No delete item",Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }

    private void init() {
        listView = findViewById(R.id.listView);
        arrName = new ArrayList<>();
        arrName.add("Jane");
        arrName.add("Harry");
        arrName.add("Jeny");
        arrName.add("Taylor");
        arrName.add("Smith");
        arrName.add("GDragon");
        adapterName = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrName);
        listView.setAdapter(adapterName);
    }
}
