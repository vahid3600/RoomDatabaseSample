package com.yaratech.roomdatabasesample.ui.post2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yaratech.roomdatabasesample.R;
import com.yaratech.roomdatabasesample.model.Post;
import com.yaratech.roomdatabasesample.ui.post1.PostRecyclerViewAdapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostFragment2 extends Fragment {

    public static String POST2_TAG = "post_fragment2";
    List<Post> posts = new ArrayList<>();
    RecyclerView recyclerView;
    PostRecyclerViewAdapter2 postRecyclerViewAdapter2;

    public PostFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.post_recyclerview);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        postRecyclerViewAdapter2 = new PostRecyclerViewAdapter2(getContext());
        posts = Arrays.asList((Post []) getArguments().getParcelableArray(POST2_TAG));
        postRecyclerViewAdapter2.setUsers(posts);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(postRecyclerViewAdapter2);
    }

    public static PostFragment2 newInstance(Post[] posts) {

        Bundle args = new Bundle();
        args.putParcelableArray(POST2_TAG, posts);
        PostFragment2 fragment = new PostFragment2();
        fragment.setArguments(args);
        return fragment;
    }
}
