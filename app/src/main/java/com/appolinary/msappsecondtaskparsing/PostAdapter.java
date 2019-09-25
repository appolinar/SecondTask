package com.appolinary.msappsecondtaskparsing;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new LinkViewHolder(...);
            case 2:
                return new VideoViewHolder(...);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                ViewHolder0 viewHolder0 = (ViewHolder0) holder;
                ...
                break;

            case 2:
                ViewHolder2 viewHolder2 = (ViewHolder2) holder;
                ...
                break;
        }
    }


    @Override
    public int getItemCount() {
        return 0;
    }


    class LinkViewHolder extends RecyclerView.ViewHolder {
        ...

        public ViewHolder0(View itemView) {
        ...
        }
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {
        ...

        public ViewHolder2(View itemView) {
        ...
        }
    }
}