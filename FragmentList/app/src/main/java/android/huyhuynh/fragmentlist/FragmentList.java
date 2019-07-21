package android.huyhuynh.fragmentlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

/**
 * Created by Huy Huynh on 07/21/19.
 */
public class FragmentList extends ListFragment {

    String[] arrCountry = {"Huế","Sài Gòn","Đà Nẵng","Hà Nội","Nha Trang","Bình Phước"};
    ArrayAdapter<String> mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Set adapter
        mAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,arrCountry);
        setListAdapter(mAdapter); //Phương thức này gọi trực tiếp mà không âần khai báo list view


        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    //Sự kiện click item
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(),arrCountry[position],Toast.LENGTH_LONG).show();

        super.onListItemClick(l, v, position, id);
    }
}
