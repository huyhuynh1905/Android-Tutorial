package android.huyhuynh.customfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huy Huynh on 07/22/19.
 */
public class FragmentListSV extends ListFragment {
    AdapterSinhVien adapterSV;
    List<SinhVien> arrSV;
    DataSendSinhVien mSendSinhVien;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mSendSinhVien = (DataSendSinhVien) getActivity();
        arrSV = new ArrayList<>();
        addSinhVien();
        adapterSV = new AdapterSinhVien(getActivity(),R.layout.item_sinhvien,arrSV);
        setListAdapter(adapterSV);

        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    //Truyền sinh viên được chọn về maincactivity
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mSendSinhVien.senData(arrSV.get(position));
        //Toast.makeText(getActivity(),arrSV.get(position).getAge()+"",Toast.LENGTH_SHORT).show();
    }

    public void addSinhVien(){
        arrSV.add(new SinhVien("Huy",19,"Huế"));
        arrSV.add(new SinhVien("Mai",19,"Huế"));
        arrSV.add(new SinhVien("Liên",18,"Đn"));
        arrSV.add(new SinhVien("Hồng",20,"HN"));
        arrSV.add(new SinhVien("Trà",21,"SG"));
        arrSV.add(new SinhVien("Cúc",19,"HN"));
        arrSV.add(new SinhVien("Hoàng",21,"ĐN"));
        arrSV.add(new SinhVien("Huỳnh",19,"SG"));

    }
}
