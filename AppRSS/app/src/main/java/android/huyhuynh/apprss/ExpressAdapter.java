package android.huyhuynh.apprss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ExpressAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    List<Express> arrExpress;

    public ExpressAdapter(Context context, int layout, List<Express> arrExpress) {
        this.context = context;
        this.layout = layout;
        this.arrExpress = arrExpress;
    }

    @Override
    public int getCount() {
        return arrExpress.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView tieude = view.findViewById(R.id.txtTieuDe);
        TextView contetn = view.findViewById(R.id.txtContent);
        TextView link = view.findViewById(R.id.txtLink);
        ImageView imgPic = view.findViewById(R.id.imgPic);

        Express e = arrExpress.get(i);
        tieude.setText(e.getTieude());
        contetn.setText(e.getContent());
        link.setText(e.getLink());
        imgPic.setImageBitmap(e.getBmAnh());

        Animation animation = AnimationUtils.loadAnimation(context,R.anim.anim_listview_custom);
        view.startAnimation(animation);


        return view;
    }
}
