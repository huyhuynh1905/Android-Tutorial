package android.huyhuynh.fragmentdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * Created by Huy Huynh on 07/21/19.
 */
public class FragmentDialog extends DialogFragment {
    //khai báo
    InterDelete mInterDelete;

    //extends từ DialogFragment
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //khởi tạo:
        mInterDelete = (InterDelete) getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Xoá");
        builder.setMessage("Bạn muốn xoá hay không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mInterDelete.giaTriXoa(true);
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mInterDelete.giaTriXoa(false);
            }
        });

        //Chuyển về dialog để return
        Dialog dialog = builder.create();

        return dialog;
    }


}
