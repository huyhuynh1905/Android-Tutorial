package android.huyhuynh.racingpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imgPlay;
    TextView txtPoint;
    SeekBar seekPika, seekMew, seekPsyDuck;
    CheckBox chkPika, chkMew, chkPsyDuck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        control();
    }

    private void init() {
        imgPlay = findViewById(R.id.imgPlay);
        txtPoint = findViewById(R.id.txtPoint);
        seekPika = findViewById(R.id.seekPikachu);
        seekMew = findViewById(R.id.seekMew);
        seekPsyDuck = findViewById(R.id.seekpsyduck);
        chkPika = findViewById(R.id.chkPikachu);
        chkMew = findViewById(R.id.chkMew);
        chkPsyDuck = findViewById(R.id.chkpsyduck);

        //
        setCheckBoxOnly();
    }

    private void control() {
        final CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                Random rd = new Random();
                //Check win
                if (seekPika.getProgress()>=100){
                    //Toast.makeText(MainActivity.this,"Pika Win!", Toast.LENGTH_SHORT).show();
                    checkWin(chkPika);
                    setEnableCheckbox();
                    this.cancel();
                }
                if (seekMew.getProgress()>=100){
                    //Toast.makeText(MainActivity.this,"Mew Win!", Toast.LENGTH_SHORT).show();
                    checkWin(chkMew);
                    setEnableCheckbox();
                    this.cancel();
                }
                if (seekPsyDuck.getProgress()>=100){
                    //Toast.makeText(MainActivity.this,"PsyDuck Win!", Toast.LENGTH_SHORT).show();
                    checkWin(chkPsyDuck);
                    setEnableCheckbox();
                    this.cancel();
                }
                seekPika.setProgress(seekPika.getProgress()+rd.nextInt(10));
                seekMew.setProgress(seekMew.getProgress()+rd.nextInt(10));
                seekPsyDuck.setProgress(seekPsyDuck.getProgress()+rd.nextInt(10));
            }

            @Override
            public void onFinish() {
                chkPika.setEnabled(true);
                chkMew.setEnabled(true);
                chkPsyDuck.setEnabled(true);
            }
        };
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int point = Integer.parseInt(txtPoint.getText().toString().trim());
                if (point==0){
                    Toast.makeText(MainActivity.this,"You Lose! Bye Bye!",
                            Toast.LENGTH_SHORT).show();
                } else if (!chkPika.isChecked()&&!chkMew.isChecked()&&!chkPsyDuck.isChecked()){
                    Toast.makeText(MainActivity.this,"Please Select Your Pet!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    setProgressStart();
                    countDownTimer.start();
                }
            }
        });
    }

    private void setProgressStart(){
        seekPika.setProgress(0);
        seekMew.setProgress(0);
        seekPsyDuck.setProgress(0);

        seekPika.setEnabled(false);
        seekMew.setEnabled(false);
        seekPsyDuck.setEnabled(false);

        chkPika.setEnabled(false);
        chkMew.setEnabled(false);
        chkPsyDuck.setEnabled(false);
    }

    private void setEnableCheckbox(){
        chkPika.setEnabled(true);
        chkMew.setEnabled(true);
        chkPsyDuck.setEnabled(true);
    }
    private void checkWin(CheckBox chkCheck){
        if (chkCheck.isChecked()){
            Toast.makeText(MainActivity.this,"You win +10",Toast.LENGTH_SHORT).show();
            int point = Integer.parseInt(txtPoint.getText().toString().trim());
            txtPoint.setText(String.valueOf(point+10));
        } else {
            Toast.makeText(MainActivity.this,"You lose -10",Toast.LENGTH_SHORT).show();
            int point = Integer.parseInt(txtPoint.getText().toString().trim());
            txtPoint.setText(String.valueOf(point-10));
        }
    }
    private void setCheckBoxOnly(){
        chkPika.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkPika.isChecked()){
                    chkMew.setChecked(false);
                    chkPsyDuck.setChecked(false);
                }
            }
        });
        chkMew.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (chkMew.isChecked()){
                    chkPika.setChecked(false);
                    chkPsyDuck.setChecked(false);
                }

            }
        });
        chkPsyDuck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkPsyDuck.isChecked()){
                    chkPika.setChecked(false);
                    chkMew.setChecked(false);
                }
            }
        });
    }
}
