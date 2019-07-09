package android.huyhuynh.menupopup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenuPopup();
            }
        });
    }

    private void showMenuPopup() {
        PopupMenu popupMenu = new PopupMenu(this, btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup_custom,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menuOption:
                        Toast.makeText(MainActivity.this,"Option Popup",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuAbout:
                        Toast.makeText(MainActivity.this,"About Popup",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuExit:
                        Toast.makeText(MainActivity.this,"Exit Popup",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}
