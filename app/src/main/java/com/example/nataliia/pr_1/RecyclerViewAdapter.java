package com.example.nataliia.pr_1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private String[] mDataset;
    private View.OnClickListener onClickListener; //[Comment] Unused

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView; //[Comment] Wrong visibility modifier

        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    public RecyclerViewAdapter(String[] dataset, View.OnClickListener listener) {
        mDataset = dataset;
        this.onClickListener = listener;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.image_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(holder.mImageView.getContext()).
                load(holder.mImageView.getContext().getResources().
                        getIdentifier(mDataset[position], "drawable", //[Comment] Hardcode. Anyway you can just use int array with ids
                                holder.mImageView.getContext().getPackageName())).
                into(holder.mImageView);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView); //[Comment] Unnecessary code
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}