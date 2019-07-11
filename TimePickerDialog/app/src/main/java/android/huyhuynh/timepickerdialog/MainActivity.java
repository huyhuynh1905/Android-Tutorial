package android.huyhuynh.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView txtHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHour = findViewById(R.id.txtHour);

        txtHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectHour();
            }
        });
    }

    private void selectHour() {
        final Calendar cal = Calendar.getInstance();
        /*int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);*/
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                SimpleDateFormat fm = new SimpleDateFormat("HH:mm:ss a");
                cal.set(Calendar.HOUR_OF_DAY,i);
                cal.set(Calendar.MINUTE,i1);
                txtHour.setText(fm.format(cal.getTime()));
            }
        },0,0,true);
        timePickerDialog.show();
    }
}
