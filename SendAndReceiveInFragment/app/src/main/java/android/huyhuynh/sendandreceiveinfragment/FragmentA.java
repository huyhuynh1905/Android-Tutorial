package android.huyhuynh.sendandreceiveinfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Huy Huynh on 07/20/19.
 */
public class FragmentA extends Fragment {
    TextView txtFragmentA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_a,container,false);
        txtFragmentA = view.findViewById(R.id.txtFragmentA);
        //Nhận dữ liệu từ activity
        Bundle bundle = getArguments();
        String duLieuNhan = bundle.getString("dataString");
        txtFragmentA.setText(duLieuNhan);

        return view;
    }
}
