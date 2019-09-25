package com.appolinary.msappsecondtaskparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.appolinary.msappsecondtaskparsing.data.BaseModel;
import com.appolinary.msappsecondtaskparsing.data.LinkModel;
import com.appolinary.msappsecondtaskparsing.data.VideoModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter2 extends RecyclerView.Adapter {
    private static final String KEY_FOR_IMAGE = "image_base";
    private static final String URL = "url reference";

    private List<BaseModel> totalList;
    private Context context;

    private final int VIDEO = 0;
    private final int LINK = 1;


    public PostAdapter2(List<BaseModel> totalList, Context context) {
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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIDEO) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.video_item, parent, false);
            return new VideoViewHolder(view);
        } else if (viewType == LINK) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.link_item, parent, false);
            return new LinkViewHolder(view);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
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
                    .into(((VideoViewHolder) holder).videoImage);//TODO ????

        } else if (holder instanceof LinkViewHolder) {
            ((LinkViewHolder) holder).linkTitle
                    .setText((totalList.get(position)).getTitle());
            ((LinkViewHolder) holder).linkSummary
                    .setText((totalList.get(position)).getSummary());
            Glide.with(context)
                    .load(getImageUrlByKey(totalList.get(position)))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(((LinkViewHolder) holder).linkImage);//TODO ????
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

    public static class VideoViewHolder extends RecyclerView.ViewHolder {
        private Button button;
        private ImageView videoImage;
        private TextView videoTitle;
        private TextView videoSummary;

        public VideoViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.video_button);
            videoImage = itemView.findViewById(R.id.video_image);
            videoTitle = itemView.findViewById(R.id.video_title);
            videoSummary = itemView.findViewById(R.id.video_summary);
        }
    }

    public static class LinkViewHolder extends RecyclerView.ViewHolder {
        public TextView linkTitle;
        public TextView linkSummary;
        public ImageView linkImage;

        public LinkViewHolder(View itemView) {
            super(itemView);
            linkTitle = itemView.findViewById(R.id.link_title);
            linkSummary = itemView.findViewById(R.id.link_summary);
            linkImage = itemView.findViewById(R.id.link_image);
        }
    }
}
