package android.huyhuynh.calendarinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = findViewById(R.id.txtTime);

        Calendar cal = Calendar.getInstance();

        //txtTime.setText(cal.getTime()+"");
        //txtTime.setText(cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR));
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
        txtTime.setText(dateFormat.format(cal.getTime()));

        //txtTime.setText(cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));


    }
}
