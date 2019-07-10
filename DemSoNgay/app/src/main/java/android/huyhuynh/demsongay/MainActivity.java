package android.huyhuynh.demsongay;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtShow;
    EditText edtDate1,edtDate2;
    Button btnCheck;

    Calendar date1,date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        edtDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDate1();
            }
        });

        edtDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDate2();
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date1Str = edtDate1.getText().toString().trim();
                String date2Str = edtDate2.getText().toString().trim();
                if (date1Str.length()==0|date2Str.length()==0){
                    Toast.makeText(MainActivity.this,"Chọn ngày",
                            Toast.LENGTH_SHORT).show();
                }else {
                    countDay();
                }
            }
        });


    }

    private void countDay() {
        int countDate =(int) (date2.getTimeInMillis() - date1.getTimeInMillis())/(1000*60*60*24);
        Log.d("Date",(int)date2.getTimeInMillis()+"-Dat22");
        Log.d("Date",(int)date1.getTimeInMillis()+"-Date1");
        Log.d("Date",(int)(date2.getTimeInMillis() - date1.getTimeInMillis())+"=Date2-Date1");
        if (countDate>=0){
            txtShow.setText("Count: "+countDate);
        } else {
            txtShow.setText("Error: "+countDate);
            Toast.makeText(MainActivity.this,"Chọn ngày 2 ở sau ngày 1",
                    Toast.LENGTH_SHORT).show();
        }
    }
    private void showDate1() {
        date1 = Calendar.getInstance();
        int y = date1.get(Calendar.YEAR);
        int m = date1.get(Calendar.MONTH);
        int d = date1.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                date1.set(i,i1,i2);
                SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
                edtDate1.setText(dateF.format(date1.getTime()));
            }
        },y,m,d);
        datePickerDialog.show();
    }

    private void showDate2() {
        date2 = Calendar.getInstance();
        int y = date2.get(Calendar.YEAR);
        int m = date2.get(Calendar.MONTH);
        int d = date2.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                date2.set(i,i1,i2);
                SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
                edtDate2.setText(dateF.format(date2.getTime()));
            }
        },y,m,d);
        datePickerDialog.show();
    }


    private void init() {
        txtShow = findViewById(R.id.txtShow);
        edtDate1 = findViewById(R.id.edtDate1);
        edtDate2 = findViewById(R.id.edtDate2);
        btnCheck = findViewById(R.id.btnCheck);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
        txtShow.setText(dateF.format(cal.getTime()));
    }


}
