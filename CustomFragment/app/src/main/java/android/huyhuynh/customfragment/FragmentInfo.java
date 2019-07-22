package android.huyhuynh.customfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Huy Huynh on 07/22/19.
 */
public class FragmentInfo extends Fragment {

    View mView;
    TextView txtTen,txtTuoi,txtDiachi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_infosv,container,false);
        txtTen = mView.findViewById(R.id.txtTen);
        txtTuoi = mView.findViewById(R.id.txtTuoi);
        txtDiachi = mView.findViewById(R.id.txtDiachi);

        return mView;
    }

    public void setInfoSinhVien(SinhVien sv){
        txtTen.setText(sv.getName());
        txtTuoi.setText(String.valueOf(sv.getAge()));
        txtDiachi.setText(sv.getDiachi());
    }
}
