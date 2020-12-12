package com.example.kingledshipper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class CongtyAdapter extends RecyclerView.Adapter<CongtyAdapter.ViewHolder>
        implements RecyclerView.OnItemTouchListener{

    private CongtyAdapter.OnItemClickListener mListener_116;
    ArrayList<Congty> cofeModelList_116;
    Context context_116;
    public CongtyAdapter(ArrayList<Congty> list_116,Context c_116){
        cofeModelList_116 = list_116;
        context_116 = c_116;
    }
    //Tạo một interface xét sự kiên onClick, longClick
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);

        public void onLongItemClick(View view, int position);
    }
    GestureDetector mGestureDetector_116;

    public CongtyAdapter(Context context, final RecyclerView recyclerView, CongtyAdapter.OnItemClickListener listener) {
        mListener_116 = listener;
        mGestureDetector_116 = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child_116 = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child_116 != null && mListener_116 != null) {
                    mListener_116.onLongItemClick(child_116, recyclerView.getChildAdapterPosition(child_116));
                }
            }
        });
    }

    @Override public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView_116 = view.findChildViewUnder(e.getX(), e.getY());
        if (childView_116 != null && mListener_116 != null && mGestureDetector_116.onTouchEvent(e)) {
            mListener_116.onItemClick(childView_116, view.getChildAdapterPosition(childView_116));
            return true;
        }
        return false;
    }

    @NonNull
    @Override
    public CongtyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CongtyAdapter.ViewHolder(LayoutInflater.from(context_116).inflate(R.layout.design_recyclerview_caccongty,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull final CongtyAdapter.ViewHolder holder, int position) {
        Congty cofe=cofeModelList_116.get(position);
        holder.ten_116.setText(cofeModelList_116.get(position).getTen());
        StorageReference storageHinhAnh  = FirebaseStorage.getInstance().getReference().child("hinhanhsanpham").child(cofe.getHinhanh());
        final long ONE_MEGABYTE_116=1024*1024;
        storageHinhAnh.getBytes(ONE_MEGABYTE_116).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                holder.hinhanh_116.setImageBitmap(bitmap);
            }
        });
    }
    @Override
    public int getItemCount() {
        return cofeModelList_116.size();    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }
    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hinhanh_116;
        TextView ten_116;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            hinhanh_116=(ImageView)itemView.findViewById(R.id.image_recycler_caccongty);
            ten_116=(TextView)itemView.findViewById(R.id.tv_recyclerview_caccongty);
        }
    }
}
