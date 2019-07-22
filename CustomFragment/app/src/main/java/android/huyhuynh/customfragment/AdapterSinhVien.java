package android.huyhuynh.customfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Huy Huynh on 07/22/19.
 */
public class AdapterSinhVien extends BaseAdapter {
    Context context;
    int layout;
    List<SinhVien> arrSv;

    public AdapterSinhVien(Context context, int layout, List<SinhVien> arrSv) {
        this.context = context;
        this.layout = layout;
        this.arrSv = arrSv;
    }

    @Override
    public int getCount() {
        return arrSv.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (holder==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtName = view.findViewById(R.id.txtName);
            view.setTag(holder);
        } else {
            view = (View) view.getTag();
        }

        SinhVien sv = arrSv.get(i);
        holder.txtName.setText(sv.getName());

        return view;
    }

    class ViewHolder{
        TextView txtName;
    }
}
