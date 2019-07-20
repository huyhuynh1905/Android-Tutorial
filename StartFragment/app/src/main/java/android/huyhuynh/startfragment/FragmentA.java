package android.huyhuynh.startfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Huy Huynh on 07/20/19.
 */
public class FragmentA extends Fragment {

    //Phương thức phải có
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //từ các tham số truyền vào để return:
        //-inflater của LayoutInflater
        //- container của ViewGroup
        return inflater.inflate(R.layout.frangment_a,container,false);
    }
}
