package com.example.internshiptask2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.TextView;

import com.bumptech.glide.Glide;

public class viewDialog {
    public void showDialog(Activity activity, String msg, String img_url, String url){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.requestWindowFeature(Window.FEATURE_SWIPE_TO_DISMISS);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialogboxdesign);
        TextView titletv = dialog.findViewById(R.id.titletv);
        Button successbtn = dialog.findViewById(R.id.successbtn);
        ImageView imgview = dialog.findViewById(R.id.imgview);
        titletv.setText(msg);
        Glide.with(activity).load(img_url).into(imgview);
        successbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url)));
            }
        });

        dialog.show();

    }
}
