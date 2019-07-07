package android.huyhuynh.gridviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gridViewAlpha;
    String arrAlpha[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","Q","P","X",
            "R","U","T","V","Y","Z"};
    ArrayAdapter<String> adapterAlpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridViewAlpha = findViewById(R.id.gridviewAlpha);
        adapterAlpha = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,
                arrAlpha);
        gridViewAlpha.setAdapter(adapterAlpha);
    }
}
