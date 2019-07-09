package android.huyhuynh.menuoption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option_custom,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAdd:
                Toast.makeText(MainActivity.this,"Menu Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuAbout:
                Toast.makeText(MainActivity.this,"Menu About",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuInfo:
                Toast.makeText(MainActivity.this,"Menu Info",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
                Toast.makeText(MainActivity.this,"Menu Exit",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSearch:
                Toast.makeText(MainActivity.this,"Menu Search",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuEx:
                Toast.makeText(MainActivity.this,"Menu Ex",Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
