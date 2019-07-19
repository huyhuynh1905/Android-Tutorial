package android.huyhuynh.insertdatafromwebservice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Huy Huynh on 07/19/19.
 */
public class AdapterSinhVien extends BaseAdapter {
    MainActivity context;
    int layout;
    List<SinhVien> arrSv;

    public AdapterSinhVien(MainActivity context, int layout, List<SinhVien> arrSv) {
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

    class ViewHolder{
        TextView txtHoten, txtDiachi, txtNamsinh;
        Button btnDel, btnEdit;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout,null);
            holder.btnDel = view.findViewById(R.id.btnDel);
            holder.btnEdit = view.findViewById(R.id.btnThem);
            holder.txtHoten = view.findViewById(R.id.txtHoten);
            holder.txtNamsinh = view.findViewById(R.id.txtNamSinh);
            holder.txtDiachi = view.findViewById(R.id.txtDiaChi);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        final SinhVien sv = arrSv.get(i);
        holder.txtNamsinh.setText(sv.getNamsinh()+"");
        holder.txtHoten.setText(sv.getHoten());
        holder.txtDiachi.setText(sv.getDiachi());

        //Sửa
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,EditSinhVienActivity.class);
                intent.putExtra("sinhvien",sv);
                context.startActivity(intent);
            }
        });
        //Xoá
        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(sv.getHoten(),sv.getId());
            }
        });
        return view;
    }

    private void showDialog(String name, final int id) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Xoá Sinh Viên");
        builder.setMessage("Bạn có muốn xoá "+name+" khỏi danh sách?");
        builder.setCancelable(false);
        builder.setPositiveButton("Xoá", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                context.deleteSinhVien(id);
            }
        });
        builder.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
}
