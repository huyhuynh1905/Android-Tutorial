package android.huyhuynh.intentwithanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button btnSecondAc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSecondAc = findViewById(R.id.btnSecondAc);
        btnSecondAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.anim_intent_enter,R.anim.anim_intent_exit);
            }
        });
    }
}
