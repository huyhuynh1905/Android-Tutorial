package android.huyhuynh.datepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtShowDate;
    Button btnPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtShowDate = findViewById(R.id.edtShowDate);
        btnPicker = findViewById(R.id.btnPicker);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFortmat = new SimpleDateFormat("dd/MM/yyyy");
        edtShowDate.setText(dateFortmat.format(calendar.getTime()));
        btnPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDatePicker();
            }
        });
    }

    private void setDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat dateFortmat = new SimpleDateFormat("dd/MM/yyyy");
                        /*calendar.set(Calendar.DATE,i2);
                        calendar.set(calendar.MONTH,i1);
                        calendar.set(Calendar.YEAR,i);*/
                        calendar.set(i,i1,i2);
                        edtShowDate.setText(dateFortmat.format(calendar.getTime()));
                    }
                },2019,1,1);
        datePickerDialog.show();
    }
}
