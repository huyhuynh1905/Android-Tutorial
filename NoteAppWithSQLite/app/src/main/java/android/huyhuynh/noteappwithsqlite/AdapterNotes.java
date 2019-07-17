package android.huyhuynh.noteappwithsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class AdapterNotes extends BaseAdapter {

    private MainActivity context;
    private int layout;
    private List<Notes> arrNotes;

    public AdapterNotes(MainActivity context, int layout, List<Notes> arrNotes) {
        this.context = context;
        this.layout = layout;
        this.arrNotes = arrNotes;
    }

    @Override
    public int getCount() {
        return arrNotes.size();
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

        ImageButton imgDel = view.findViewById(R.id.imgDel);
        ImageButton imgEdit = view.findViewById(R.id.imgEdit);
        TextView txtNotes = view.findViewById(R.id.txtNotes);

        final Notes notes = arrNotes.get(i);
        txtNotes.setText(notes.getName());

        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.editNotesToDatabase(notes.getName(),notes.getKey());
            }
        });
        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.delNotesDatabase(notes.getKey());
            }
        });

        return view;
    }
}
