package com.htv.hhy.vod.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htv.hhy.vod.R;
import com.htv.hhy.vod.adapter.holder.MyViewHolder;

import java.util.List;

/**
 * Created by admin on 2017/10/25.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener{

    private Context mContext;
    private List<Integer> srclist;


    public MyAdapter(Context mContext,List<Integer> srclist) {
        this.mContext = mContext;
        this.srclist = srclist;
    }



    /**
     * 1.在MyAdapter中定义如下接口,模拟ListView的OnItemClickListener：
     */
    public static interface OnItemClickListener{
        void onItemClick(View view,int pos);
    }

    /**
     * 2.声明一个这个接口的变量
     */
    private OnItemClickListener mOnItemClickListener = null;

    /**
     * 5.将点击事件转移给外面的调用者：
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null){
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    /**
     * 6.最后定义设置item点击监听的方法，暴露给外面的调用者
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_hot_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        //3.在onCreateViewHolder()中为每个item添加点击事件
        view.setOnClickListener(this);
        return holder;
    }

    /**
     * 4.注意上面调用接口的onItemClick()中的v.getTag()方法，这需要在onBindViewHolder()方法中设置和item的position
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mImageView.setImageResource(srclist.get(position));
        //将position保存在item的Tag中，以便于点击时获取
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return srclist == null ? 0 : srclist.size();
    }
}
