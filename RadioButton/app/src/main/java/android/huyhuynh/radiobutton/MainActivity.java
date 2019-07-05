package android.huyhuynh.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radGroup;
    RadioButton radMorning, radAfternoon, radNight;
    Button btnSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        control();
    }

    private void control() {
        radGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radMorning:
                        Toast.makeText(MainActivity.this, "Morning",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radAfternoon:
                        Toast.makeText(MainActivity.this, "Afternoon",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radNight:
                        Toast.makeText(MainActivity.this, "Night",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radMorning.isChecked()){
                    Toast.makeText(MainActivity.this, "Morning Checked",Toast.LENGTH_SHORT).show();
                    radNight.setEnabled(false);
                }
                if (radAfternoon.isChecked()){
                    Toast.makeText(MainActivity.this, "Afternoon Checked",Toast.LENGTH_SHORT).show();
                }
                if (radNight.isChecked()){
                    Toast.makeText(MainActivity.this, "Night Checked",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        radGroup = findViewById(R.id.radGroup);
        radAfternoon = findViewById(R.id.radAfternoon);
        radMorning = findViewById(R.id.radMorning);
        radNight = findViewById(R.id.radNight);
        btnSelect = findViewById(R.id.btnSelect);
    }
}
