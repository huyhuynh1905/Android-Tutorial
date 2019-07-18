package android.huyhuynh.saveimagetosqlite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterImage extends BaseAdapter {

    public MainActivity context;
    public int layout;
    public List<ImageClass> arrImg;

    public AdapterImage(MainActivity context, int layout, List<ImageClass> arrImg) {
        this.context = context;
        this.layout = layout;
        this.arrImg = arrImg;
    }

    @Override
    public int getCount() {
        return arrImg.size();
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
        ImageClass imgClass = arrImg.get(i);
        ImageView imgPic = view.findViewById(R.id.imgPic);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtInfo = view.findViewById(R.id.txtInfo);
        //Chuyển byte[] ảnh vể bitmap
        byte[] picture = imgClass.getPicture();
        Bitmap bm = (Bitmap) BitmapFactory.decodeByteArray(picture,0,picture.length);
        //set
        txtInfo.setText(imgClass.getInfo());
        txtName.setText(imgClass.getName());
        imgPic.setImageBitmap(bm);

        return view;
    }
}
