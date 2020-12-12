package com.example.kingledshipper;

import android.content.Context;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GiohangAdapter extends BaseAdapter {


    Context context_116;
    ArrayList<Giohang> list_116;

    public GiohangAdapter(Context context_116, ArrayList<Giohang> list_116) {
        this.context_116 = context_116;
        this.list_116 = list_116;
    }

    @Override
    public int getCount() {
        return list_116.size();
    }

    @Override
    public Object getItem(int position) {
        return list_116.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        public TextView tengiohang_116, giagiohang_116;
        public ImageView imggiohang_116;
        public Button btmin_116, btmax_116, btvalue_116;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder_116 = null;
        if(viewHolder_116 == null){
            viewHolder_116 = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context_116.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.design_giohang,null);
            viewHolder_116.tengiohang_116 = (TextView)convertView.findViewById(R.id.tv_tengiohang);
            viewHolder_116.giagiohang_116 = (TextView)convertView.findViewById(R.id.tv_giagiohang);
            viewHolder_116.imggiohang_116 = (ImageView)convertView.findViewById(R.id.img_giohang);
            viewHolder_116.btmin_116 = (Button)convertView.findViewById(R.id.bt_min);
            viewHolder_116.btmax_116 = (Button)convertView.findViewById(R.id.bt_max);
            viewHolder_116.btvalue_116 = (Button)convertView.findViewById(R.id.bt_value);
            convertView.setTag(viewHolder_116);
        }else{
            viewHolder_116 = (ViewHolder) convertView.getTag();
        }
        final Giohang sanpham_116 = (Giohang) getItem(position);
        viewHolder_116.tengiohang_116.setText(sanpham_116.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder_116.giagiohang_116.setText(decimalFormat.format(sanpham_116.getGiasp())+ ".000đ");
        Picasso.with(context_116).load(sanpham_116.getHinh()).into(viewHolder_116.imggiohang_116);
        viewHolder_116.btvalue_116.setText(sanpham_116.getSoluongsp() + "");
        int soluong = Integer.parseInt(viewHolder_116.btvalue_116.getText().toString());
        if(soluong >= 10){
            viewHolder_116.btmax_116.setVisibility(View.INVISIBLE);
            viewHolder_116.btmin_116.setVisibility(View.VISIBLE);
        }else if(soluong <= 1){
            viewHolder_116.btmin_116.setVisibility(View.INVISIBLE);
        }else if(soluong >= 1){
            viewHolder_116.btmax_116.setVisibility(View.VISIBLE);
            viewHolder_116.btmin_116.setVisibility(View.VISIBLE);
        }
        final ViewHolder finalViewHolder_116 = viewHolder_116;
        viewHolder_116.btmax_116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat = Integer.parseInt(finalViewHolder_116.btvalue_116.getText().toString()) + 1;
                int slhientai = trangchu.listgiohang_116.get(position).getSoluongsp();
                long giahientai = trangchu.listgiohang_116.get(position).getGiasp();
                trangchu.listgiohang_116.get(position).setSoluongsp(slmoinhat);
                long giamoinhat = (giahientai * slmoinhat)/slhientai;
                trangchu.listgiohang_116.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder_116.giagiohang_116.setText(decimalFormat.format(giamoinhat)+ ".000đ");
                GiohangActivity.EventUltil();
                if(slmoinhat > 9){
                    finalViewHolder_116.btmax_116.setVisibility(View.INVISIBLE);
                    finalViewHolder_116.btmin_116.setVisibility(View.VISIBLE);
                    finalViewHolder_116.btvalue_116.setText(String.valueOf(slmoinhat));
                }else{
                    finalViewHolder_116.btmax_116.setVisibility(View.VISIBLE);
                    finalViewHolder_116.btmin_116.setVisibility(View.VISIBLE);
                    finalViewHolder_116.btvalue_116.setText(String.valueOf(slmoinhat));
                }
            }
        });
        viewHolder_116.btmin_116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat_116 = Integer.parseInt(finalViewHolder_116.btvalue_116.getText().toString()) - 1;
                int slhientai_116 = trangchu.listgiohang_116.get(position).getSoluongsp();
                long giahientai_116 = trangchu.listgiohang_116.get(position).getGiasp();
                trangchu.listgiohang_116.get(position).setSoluongsp(slmoinhat_116);
                long giamoinhat = (giahientai_116 * slmoinhat_116)/slhientai_116;
                trangchu.listgiohang_116.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat_116 = new DecimalFormat("###,###,###");
                finalViewHolder_116.giagiohang_116.setText(decimalFormat_116.format(giamoinhat)+ ".000đ");
                GiohangActivity.EventUltil();
                if(slmoinhat_116 < 2){
                    finalViewHolder_116.btmax_116.setVisibility(View.VISIBLE);
                    finalViewHolder_116.btmin_116.setVisibility(View.INVISIBLE);
                    finalViewHolder_116.btvalue_116.setText(String.valueOf(slmoinhat_116));
                }else{
                    finalViewHolder_116.btmax_116.setVisibility(View.VISIBLE);
                    finalViewHolder_116.btmin_116.setVisibility(View.VISIBLE);
                    finalViewHolder_116.btvalue_116.setText(String.valueOf(slmoinhat_116));
                }
            }
        });
        return convertView;
    }
}
