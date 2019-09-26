package com.appolinary.msappsecondtaskparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appolinary.msappsecondtaskparsing.data.BaseModel;
import com.appolinary.msappsecondtaskparsing.data.LinkModel;
import com.appolinary.msappsecondtaskparsing.data.VideoModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter {
    private static final String KEY_FOR_IMAGE = "image_base";

    private List<BaseModel> totalList;
    private Context context;

    private final int VIDEO = 0;
    private final int LINK = 1;


    public PostAdapter(List<BaseModel> totalList, Context context) {
        this.totalList = totalList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (totalList.get(position) instanceof LinkModel) {
            return LINK;
        } else if (totalList.get(position) instanceof VideoModel) {
            return VIDEO;
        } else {
            return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIDEO) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.video_item, parent, false);
            return new VideoViewHolder(view);
        } else /*if (viewType == LINK)*/ {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.link_item, parent, false);
            return new LinkViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VideoViewHolder) {

            ((VideoViewHolder) holder).button
                    .setOnClickListener(((VideoModel) totalList.get(position)).getOnClickListener());

            ((VideoViewHolder) holder).videoTitle
                    .setText((totalList.get(position)).getTitle());
            ((VideoViewHolder) holder).videoSummary
                    .setText((totalList.get(position)).getSummary());
            Glide.with(context)
                    .load(getImageUrlByKey(totalList.get(position)))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(((VideoViewHolder) holder).videoImage);

        } else if (holder instanceof LinkViewHolder) {
            ((LinkViewHolder) holder).linkRelativeLayout
                    .setOnClickListener(((LinkModel) totalList.get(position)).getOnClickListener());//very brave experiment...
            ((LinkViewHolder) holder).linkTitle
                    .setText((totalList.get(position)).getTitle());
            ((LinkViewHolder) holder).linkSummary
                    .setText((totalList.get(position)).getSummary());
            Glide.with(context)
                    .load(getImageUrlByKey(totalList.get(position)))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(((LinkViewHolder) holder).linkImage);
        }
    }

    private String getImageUrlByKey(BaseModel baseModel) {
        for (BaseModel.MediaGroup mediaGroup : baseModel.getMediaGroups()) {
            for (BaseModel.MediaItem mediaItem : mediaGroup.getMediaItems()) {
                if (mediaItem.getKey().equalsIgnoreCase(KEY_FOR_IMAGE))
                    return mediaItem.getSrc();
            }
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return totalList.size();
    }

    private static class VideoViewHolder extends RecyclerView.ViewHolder {
        private Button button;
        private ImageView videoImage;
        private TextView videoTitle;
        private TextView videoSummary;

        private VideoViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.video_button);
            videoImage = itemView.findViewById(R.id.video_image);
            videoTitle = itemView.findViewById(R.id.video_title);
            videoSummary = itemView.findViewById(R.id.video_summary);
        }
    }

    private static class LinkViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linkRelativeLayout;
        private TextView linkTitle;
        private TextView linkSummary;
        private ImageView linkImage;

        private LinkViewHolder(View itemView) {
            super(itemView);
            linkRelativeLayout = itemView.findViewById(R.id.link_relative);
            linkTitle = itemView.findViewById(R.id.link_title);
            linkSummary = itemView.findViewById(R.id.link_summary);
            linkImage = itemView.findViewById(R.id.link_image);
        }
    }

    public void updateList(List<BaseModel> newList) {
        totalList = new ArrayList<>();
        totalList.addAll(newList);
        notifyDataSetChanged();
    }

//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextChange(String newText) {
//        String userInput = newText.toLowerCase();
//        List<BaseModel> newList = new ArrayList<>();
//
//        for(BaseModel baseModel : baseModels){
//            if(baseModel.getTitle().toLowerCase().contains(userInput)){
//                newList.add(baseModel);
//            }
//        }
//        adapter.updateList(newList);
//        return true;
//    }
}
