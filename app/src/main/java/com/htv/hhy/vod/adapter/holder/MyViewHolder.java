package com.htv.hhy.vod.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.htv.hhy.vod.R;

/**
 * Created by admin on 2017/10/25.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public ImageView mImageView;
    public MyViewHolder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.image_view);
    }
}
