package com.yaratech.roomdatabasesample.ui.post1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yaratech.roomdatabasesample.R;
import com.yaratech.roomdatabasesample.data.model.Post;
import com.yaratech.roomdatabasesample.ui.SetOnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vah on 8/4/2018.
 */

public class PostRecyclerViewAdapter1 extends RecyclerView.Adapter<PostRecyclerViewAdapter1.ViewHolder> {

    private List<Post> posts = new ArrayList<>();
    SetOnClickListener setOnClickListener;

    public PostRecyclerViewAdapter1(Context context){
        setOnClickListener = (SetOnClickListener)context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    public void setUsers(List<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(posts.get(position));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return posts.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView id;
        TextView title;
        TextView description;

        ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.post_id);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);

            itemView.setOnClickListener(this);
        }

        public void onBind(Post post) {
            id.setText(post.getId()+"");
            title.setText(post.getTitle()+"");
            description.setText(post.getDescription()+"");
        }

        @Override
        public void onClick(View v) {
            setOnClickListener.onPostClick1(posts.get(getAdapterPosition()).getId());
        }
    }
}


