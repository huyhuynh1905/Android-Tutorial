package android.huyhuynh.retrofitadvanced;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Huy Huynh on 09/05/19.
 */
public class MenuAdapter extends BaseAdapter {

    Context mContext;
    int layout;
    List<Menu> arrMenu;

    public MenuAdapter(Context context, int layout, List<Menu> arrMenu) {
        mContext = context;
        this.layout = layout;
        this.arrMenu = arrMenu;
    }

    @Override
    public int getCount() {
        return arrMenu.size();
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

        ViewHolder viewHolder;
        if (view == null){
            // inflate the layout
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            // set up the ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.txtTen = view.findViewById(R.id.txtTen);
            viewHolder.txtGia = view.findViewById(R.id.txtGia);
            viewHolder.imgHinh = view.findViewById(R.id.imgHinh);

            // store the holder with the view
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        String ten = arrMenu.get(i).getTenThucUong();
        String gia = String.valueOf(arrMenu.get(i).getDonGia());

        viewHolder.txtTen.setText(ten);
        viewHolder.txtGia.setText("Giá: "+gia);


        return view;
    }
    static class ViewHolder{
        TextView txtTen,txtGia;
        ImageView imgHinh;
    }
}
