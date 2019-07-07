package android.huyhuynh.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewColor;
    List<String> mColor;
    ArrayAdapter<String> arrAdapterColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        listViewColor = findViewById(R.id.listViewColor);
        //
        mColor = new ArrayList<>();
        mColor.add("Blue");
        mColor.add("Red");
        mColor.add("Green");
        mColor.add("Black");
        mColor.add("White");
        //
        arrAdapterColor = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,
                mColor);
        listViewColor.setAdapter(arrAdapterColor);
    }
}
