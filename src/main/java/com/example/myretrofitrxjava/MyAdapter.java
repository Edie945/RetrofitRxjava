package com.example.myretrofitrxjava;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter{

    private List<Beans.DataBean> list;
    private Context context;

    public MyAdapter(List<Beans.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.item_layout,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        ((ViewHolder) holder).tex.setText(list.get(position).getName());
        Uri uri = Uri.parse(list.get(position).getIcon());
        ((ViewHolder) holder).img.setImageURI(uri);
//        Glide.with(context).load(list.get(position).getIcon()).into(((ViewHolder) holder).img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView img;
//        ImageView img;
        TextView tex;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.sv);
            tex = itemView.findViewById(R.id.text2);
        }
    }
}
