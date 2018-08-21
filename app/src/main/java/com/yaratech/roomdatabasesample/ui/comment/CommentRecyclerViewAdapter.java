package com.yaratech.roomdatabasesample.ui.comment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yaratech.roomdatabasesample.R;
import com.yaratech.roomdatabasesample.model.Comment;
import com.yaratech.roomdatabasesample.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vah on 8/4/2018.
 */

public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentRecyclerViewAdapter.ViewHolder> {

    private List<Comment> comments = new ArrayList<>();

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        return new ViewHolder(view);
    }

    public void setUsers(List<Comment> comments){
        this.comments = comments;
        notifyDataSetChanged();
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(comments.get(position));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return comments.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView commentTextview;

        ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.comment_id);
            commentTextview = itemView.findViewById(R.id.comment);
        }

        public void onBind(Comment comment) {
            id.setText(comment.getId()+"");
            commentTextview.setText(comment.getComment()+"");
        }
    }
}


