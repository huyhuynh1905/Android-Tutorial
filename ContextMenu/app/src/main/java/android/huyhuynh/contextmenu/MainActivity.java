package android.huyhuynh.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = findViewById(R.id.btnMenu);
        registerForContextMenu(btnMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_custom_context,menu);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.drawable.ic_launcher_background);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuOp:
                Toast.makeText(MainActivity.this,"Option",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuAb:
                Toast.makeText(MainActivity.this,"About",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuEx:
                Toast.makeText(MainActivity.this,"Exit",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
