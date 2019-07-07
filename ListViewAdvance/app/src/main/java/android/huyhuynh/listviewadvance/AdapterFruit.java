package android.huyhuynh.listviewadvance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterFruit extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Fruit> arrFruit;

    public AdapterFruit(Context context, int layout, List<Fruit> arrFruit) {
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
        LayoutInflater inflaterLayout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflaterLayout.inflate(layout,null);

        //init
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtInfo = view.findViewById(R.id.txtInfo);
        ImageView imgPic = view.findViewById(R.id.imgPic);
        //
        Fruit fruit = arrFruit.get(i);
        txtName.setText(fruit.getName());
        txtInfo.setText(fruit.getInfo());
        imgPic.setImageResource(fruit.getPicture());

        return view;
    }
}
