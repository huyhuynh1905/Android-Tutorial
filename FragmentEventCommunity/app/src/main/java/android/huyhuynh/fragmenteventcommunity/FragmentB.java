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
public class FragmentB extends Fragment {

    Button btnFragB;
    TextView txtFragB;
    EditText edtFragB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);
        //Ánh xạ:
        btnFragB = view.findViewById(R.id.btnFragmentB);
        txtFragB = view.findViewById(R.id.txtFragB);
        edtFragB = view.findViewById(R.id.edtFragmentB);

        //Button này để bắt sự kiên fragment B giao tiếp với fragment A
        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ánh xạ tới txt của Fragment A
                TextView txtFragA = getActivity().findViewById(R.id.txtFragA);
                txtFragA.setText(edtFragB.getText().toString());
            }
        });
        return view;
    }
}
