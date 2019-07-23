package android.huyhuynh.apiyoutubeplaylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Huy Huynh on 07/23/19.
 */
public class AdapterVideo extends BaseAdapter {

    Context mContext;
    int layout;
    List<VideoYouTube> arrVideo;

    public AdapterVideo(Context context, int layout, List<VideoYouTube> arrVideo) {
        mContext = context;
        this.layout = layout;
        this.arrVideo = arrVideo;
    }

    @Override
    public int getCount() {
        return arrVideo.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder {
        ImageView imgThumnails;
        TextView txtTittle;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.imgThumnails = view.findViewById(R.id.imgThumnails);
            holder.txtTittle = view.findViewById(R.id.txtTittle);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        VideoYouTube video = arrVideo.get(i);
        holder.txtTittle.setText(video.getTittle());
        //Load hình dùng thư viện
        Picasso.with(mContext).load(video.getThumnails()).into(holder.imgThumnails);

        return view;
    }
}
