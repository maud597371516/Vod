package com.htv.hhy.vod.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.htv.hhy.vod.MainActivity;
import com.htv.hhy.vod.R;
import com.htv.hhy.vod.adapter.holder.PlayListViewHolder;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */

public class PlayListAdapter extends BaseAdapter {

    private List<String> names;
    private Context mContext;
    private int p;

    public PlayListAdapter(List<String> names, Context mContext) {
        this.names = names;
        this.mContext = mContext;
    }

    public void getId(int pos){
        this.p=pos;
    }

    @Override
    public int getCount() {
        return names == null ? 0 : names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlayListViewHolder holder;
        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.play_list_item,parent,false);
            holder = new PlayListViewHolder();
            holder.mNameTv = (TextView) view.findViewById(R.id.name_tv);
            view.setTag(holder);
        } else {
            holder = (PlayListViewHolder) view.getTag();
        }
        if (position == MainActivity.pageCurrent){
            holder.mNameTv.setTextColor(Color.parseColor("#ff7d00"));
            view.setBackgroundColor(Color.parseColor("#1a1a1a"));
        }else {
            holder.mNameTv.setTextColor(Color.parseColor("#ffffff"));
            view.setBackgroundColor(Color.parseColor("#434343"));
        }
        holder.mNameTv.setText(names.get(position));
        return view;
    }
}
