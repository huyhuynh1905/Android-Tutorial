package android.huyhuynh.qrcodeexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button btnQuetQR;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQuetQR = findViewById(R.id.btnCamera);
        txtName = findViewById(R.id.txtName);
        //Khai báo đọc QR
        final IntentIntegrator intentIntegrator = new IntentIntegrator(this);

        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE); //Kiểu quét
        intentIntegrator.setPrompt(""); // dòng chữ tr
        //intentIntegrator.setCameraId(0);  // Use a specific camera of the device
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setBeepEnabled(false); //Tiếng kêu sau khi quét xong
        intentIntegrator.setBarcodeImageEnabled(true);
        intentIntegrator.setTimeout(10000); //Thời gian cho đến khi kết thúc



        btnQuetQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentIntegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (intentResult!=null){
            if (intentResult.getContents()==null){
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                try {
                    JSONObject jsonObject = new JSONObject(intentResult.getContents());
                    int maban = jsonObject.getInt("maban");
                    int current = (int) System.currentTimeMillis();
                    txtName.setText(maban+"+"+current);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
