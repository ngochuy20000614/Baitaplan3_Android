package com.example.kingledshipper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    public ArrayList<Chitietsanpham> arraylistListener_116;
    private List<Chitietsanpham> mListenerList_116;
    Context mContext_116;

    public ListViewAdapter(List<Chitietsanpham> mListenerList_116, Context context_116) {
        mContext_116 = context_116;
        this.mListenerList_116 = mListenerList_116;
        this.arraylistListener_116 = new ArrayList<Chitietsanpham>();
        this.arraylistListener_116.addAll(mListenerList_116);
    }

    public class ViewHolder {
        ShapeableImageView mItemPic_116;
    }

    @Override
    public int getCount() {
        return mListenerList_116.size();
    }

    @Override
    public Object getItem(int position) {
        return mListenerList_116.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder_116;
        if (view == null) {
            view = LayoutInflater.from(mContext_116).inflate(R.layout.design_listview_chitietsanpham, null);
            holder_116 = new ViewHolder();
            holder_116.mItemPic_116 = (ShapeableImageView) view.findViewById(R.id.img_chitietsanpham);
            view.setTag(holder_116);
        } else {
            holder_116 = (ViewHolder) view.getTag();

        }
        try {
            int image = mListenerList_116.get(position).getImage();
            holder_116.mItemPic_116.setImageResource(image);
        } catch (Exception ex) {
        }
        return view;
    }
}
