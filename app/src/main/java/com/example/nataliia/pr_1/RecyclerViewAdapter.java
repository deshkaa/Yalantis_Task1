package com.example.nataliia.pr_1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private int[] mDataset;
    private View.OnClickListener onClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    public RecyclerViewAdapter(int[] dataset, View.OnClickListener listener) {
        mDataset = dataset;
        this.onClickListener = listener;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.image_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(holder.mImageView.getContext()).load(mDataset[position]).into(holder.mImageView);
        holder.mImageView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
