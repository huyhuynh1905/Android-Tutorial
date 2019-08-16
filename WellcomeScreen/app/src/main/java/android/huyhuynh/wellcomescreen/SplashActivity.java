package android.huyhuynh.wellcomescreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.snackbar.Snackbar;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Chỉnh full Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        final ConstraintLayout splashConstrLayout = findViewById(R.id.splashConstrLayout);

        //Load internect
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (!isConnected()){
                        Snackbar snackbar = Snackbar.make(splashConstrLayout,"Không có kết nối Internet!",
                                Snackbar.LENGTH_INDEFINITE)
                                .setAction("Thử Lại", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        recreate();
                                    }
                                });
                        snackbar.show();
                    } else {
                        goMainActivity();
                    }
                }
            }
        };
        thread.start();

    }



    //Kiểm tra có kết nối internet không
    public boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Service.CONNECTIVITY_SERVICE);
        if (connectivityManager!=null){
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null){
                if (networkInfo.getState()==NetworkInfo.State.CONNECTED){
                    return true;
                }
                if (networkInfo.getState()==NetworkInfo.State.DISCONNECTED){
                    return false;
                }
            }
        }
        return false;
    }

    //Load về trang chủ
    public void goMainActivity(){
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
