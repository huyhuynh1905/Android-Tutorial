package android.huyhuynh.gridviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridViewAlpha;
    /*String arrAlpha[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","Q","P","X",
            "R","U","T","V","Y","Z"};*/
    AdapterFuit adapterFruit;
    List<Fruit> arrFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        gridViewAlpha = findViewById(R.id.gridviewAlpha);
        arrFruit = new ArrayList<>();
        //
        arrFruit.add(new Fruit("Apple",R.drawable.apple));
        arrFruit.add(new Fruit("Banana",R.drawable.banana));
        arrFruit.add(new Fruit("Grapes",R.drawable.grapes));
        arrFruit.add(new Fruit("Orange",R.drawable.orange));
        arrFruit.add(new Fruit("Pineapple",R.drawable.pineapple));
        arrFruit.add(new Fruit("Strawberry",R.drawable.strawberry));
        arrFruit.add(new Fruit("Tomato",R.drawable.tomato));
        adapterFruit = new AdapterFuit(MainActivity.this,R.layout.layout_fruit_item,
                arrFruit);
        gridViewAlpha.setAdapter(adapterFruit);
    }
}
