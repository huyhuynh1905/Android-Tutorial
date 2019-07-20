package android.huyhuynh.fragmenteventcommunity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Huy Huynh on 07/20/19.
 */
public class FragmentA extends Fragment {
    Button btnFragA;
    TextView txtFragA;
    EditText edtFragA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Khai báo kiểu view trả vể ở onCreateView thay vì trả về luôn để ánh xạ:
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        //Ánh xạ
        btnFragA = view.findViewById(R.id.btnFragmentA);
        txtFragA = view.findViewById(R.id.txtFragA);
        edtFragA = view.findViewById(R.id.edtFragmentA);

        //Sự kiện nhân button thì fragment A gửi edt qua Activity
        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khai báo TextView main
                TextView txtMain = getActivity().findViewById(R.id.txtMain);
                txtMain.setText(edtFragA.getText().toString());
            }
        });

        return view;
    }
    //Phương thức này được gọi ở buttonChange ở activity để setText cho Fragment A
    public void ganTextViewFragA(String noidung){
        txtFragA.setText(noidung);
    }
}
