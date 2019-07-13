package android.huyhuynh.animationtranstale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgTranstale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgTranstale = findViewById(R.id.imgTranslate);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_custom_translate);

        imgTranstale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animation);
            }
        });
    }

}
