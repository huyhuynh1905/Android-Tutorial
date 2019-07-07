package android.huyhuynh.listviewadvance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewFruit;
    List<Fruit> arrFuit;
    AdapterFruit adapterFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        init();
    }

    private void init() {
        listViewFruit = findViewById(R.id.listviewFruit);
        arrFuit = new ArrayList<>();

        arrFuit.add(new Fruit("Apple","Apple Infomation",R.drawable.apple));
        arrFuit.add(new Fruit("Banana","Banana Infomation",R.drawable.banana));
        arrFuit.add(new Fruit("Grapes","Grapes Infomation",R.drawable.grapes));
        arrFuit.add(new Fruit("Orange","Orange Infomation",R.drawable.orange));
        arrFuit.add(new Fruit("Pineapple","Pineapple Infomation",R.drawable.pineapple));
        arrFuit.add(new Fruit("Strawberry","Strawberry Infomation",R.drawable.strawberry));
        arrFuit.add(new Fruit("Tomato","Tomato Infomation",R.drawable.tomato));

        adapterFruit = new AdapterFruit(MainActivity.this,R.layout.layout_fruit_item,arrFuit);
        listViewFruit.setAdapter(adapterFruit);
    }
}
