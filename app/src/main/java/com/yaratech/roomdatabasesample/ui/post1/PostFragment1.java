package com.yaratech.roomdatabasesample.ui.post1;

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
import com.yaratech.roomdatabasesample.data.model.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostFragment1 extends Fragment {

    public static String POST1_TAG = "post_fragment1";
    List<Post> posts = new ArrayList<>();
    RecyclerView recyclerView;
    PostRecyclerViewAdapter1 postRecyclerViewAdapter1;

    public PostFragment1() {
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
        postRecyclerViewAdapter1 = new PostRecyclerViewAdapter1(getContext());
        posts = Arrays.asList((Post []) getArguments().getParcelableArray(POST1_TAG));
        postRecyclerViewAdapter1.setUsers(posts);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(postRecyclerViewAdapter1);

    }

    public static PostFragment1 newInstance(Post[] posts) {

        Bundle args = new Bundle();
        args.putParcelableArray(POST1_TAG, posts);
        PostFragment1 fragment = new PostFragment1();
        fragment.setArguments(args);
        return fragment;
    }
}
