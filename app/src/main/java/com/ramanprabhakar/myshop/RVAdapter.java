package com.ramanprabhakar.myshop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ramanprabhakar.myshop.Model.Doc;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Raman on 5/22/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    private ArrayList<Doc> list = new ArrayList<>();
    Context mContext;
    String title;
    String image_url;

    public RVAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<Doc> getList() {
        return list;
    }

    public void setList(ArrayList<Doc> list) {
        this.list = list;
    }

    @Override
    public RVAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rv_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RVAdapter.MyViewHolder holder, final int position) {

        MyViewHolder viewHolder = (MyViewHolder) holder;
        title = list.get(position).getTitle();
        image_url = list.get(position).getLarge_image_url();

//        viewHolder.tvItem.setText(title);

        if (image_url != null){
            Picasso.with(mContext)
                    .load(image_url)
                    .into(holder.ivItem);
        }

        holder.ivItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pid = list.get(position).getPid();
                Intent detailsIntent = new Intent(mContext, DetailsActivity.class);
                detailsIntent.putExtra(AppConstants.PID , pid);
                mContext.startActivity(detailsIntent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivItem;
//        TextView tvItem;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivItem = (ImageView)itemView.findViewById(R.id.iv_item);
//            tvItem = (TextView)itemView.findViewById(R.id.tv_item);

        }
    }
}
