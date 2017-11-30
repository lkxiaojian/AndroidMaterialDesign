package com.androidmaterialdesign.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lk on 2017/11/29.
 */

public class FabRecycleViewAdapter extends RecyclerView.Adapter<FabRecycleViewAdapter.MyViewHolder> {
    private List<String> mData;

    public FabRecycleViewAdapter(List<String> data) {
        mData = data;
    }

    @Override
    public FabRecycleViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), android.R.layout.simple_list_item_1, null);
        itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FabRecycleViewAdapter.MyViewHolder holder, int position) {
        holder.mTv.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }
}
