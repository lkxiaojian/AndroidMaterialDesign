package com.androidmaterialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidmaterialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<String> mDemoData;
    private Context mContext;

    public DemoAdapter(Context context) {
        mContext = context;
        List<String> demoData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            demoData.add("Android -- " + i);
        }
        mDemoData = demoData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DemoViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((DemoViewHolder) holder).mTxtItem.setText(mDemoData.get(position));
    }

    @Override
    public int getItemCount() {
        return mDemoData == null ? 0 : mDemoData.size();
    }

    class DemoViewHolder extends RecyclerView.ViewHolder {

        TextView mTxtItem;

        public DemoViewHolder(View itemView) {
            super(itemView);
            mTxtItem = (TextView) itemView.findViewById(R.id.txt_item);
        }
    }
}
