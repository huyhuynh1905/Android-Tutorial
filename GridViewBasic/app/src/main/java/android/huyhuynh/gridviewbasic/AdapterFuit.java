package android.huyhuynh.gridviewbasic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterFuit extends BaseAdapter {

    public Context context;
    public int layout;
    public List<Fruit> arrFruit;

    public AdapterFuit(Context context, int layout, List<Fruit> arrFruit) {
        this.context = context;
        this.layout = layout;
        this.arrFruit = arrFruit;
    }

    @Override
    public int getCount() {
        return arrFruit.size();
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(layout,null);

        TextView txtName = view.findViewById(R.id.txtName);
        ImageView imgPic = view.findViewById(R.id.imgPic);

        Fruit fruit = arrFruit.get(i);
        txtName.setText(fruit.getName());
        imgPic.setImageResource(fruit.getPicture());

        return view;
    }
}
