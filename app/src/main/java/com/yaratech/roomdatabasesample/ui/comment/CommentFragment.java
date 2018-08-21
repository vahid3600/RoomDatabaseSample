package com.yaratech.roomdatabasesample.ui.comment;

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
import com.yaratech.roomdatabasesample.data.model.Comment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommentFragment extends Fragment {

    public static String COMMENT_TAG = "comment_fragment";
    List<Comment> comments = new ArrayList<>();
    RecyclerView recyclerView;
    CommentRecyclerViewAdapter commentRecyclerViewAdapter;

    public CommentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.comment_recyclerview);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        commentRecyclerViewAdapter = new CommentRecyclerViewAdapter();
        comments = Arrays.asList((Comment []) getArguments().getParcelableArray(COMMENT_TAG));
        commentRecyclerViewAdapter.setUsers(comments);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(commentRecyclerViewAdapter);

    }

    public static CommentFragment newInstance(Comment[] comments) {

        Bundle args = new Bundle();
        args.putParcelableArray(COMMENT_TAG, comments);
        CommentFragment fragment = new CommentFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
