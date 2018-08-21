package com.yaratech.roomdatabasesample.ui.user1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yaratech.roomdatabasesample.R;
import com.yaratech.roomdatabasesample.model.User;
import com.yaratech.roomdatabasesample.ui.SetOnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vah on 8/4/2018.
 */

public class UserRecyclerViewAdapter1 extends RecyclerView.Adapter<UserRecyclerViewAdapter1.ViewHolder> {

    private List<User> users = new ArrayList<>();
    SetOnClickListener setOnClickListener;

    public UserRecyclerViewAdapter1(Context context){
        setOnClickListener = (SetOnClickListener)context;
    }
    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    public void setUsers(List<User> users){
        this.users = users;
        Log.e("Tag", users.size()+"");
        notifyDataSetChanged();
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(users.get(position));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return users.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView id;
        TextView name;
        TextView family;
        TextView code;

        ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.user_id);
            name = itemView.findViewById(R.id.name);
            family = itemView.findViewById(R.id.family);
            code = itemView.findViewById(R.id.code);

            itemView.setOnClickListener(this);
        }

        public void onBind(User user) {
            id.setText(user.getId()+"");
            name.setText(user.getName()+"");
            family.setText(user.getFamilyName()+"");
            code.setText(user.getNationalCode()+"");
        }

        @Override
        public void onClick(View v) {
            setOnClickListener.onUserClick1(users.get(getAdapterPosition()).getId());
        }
    }
}


