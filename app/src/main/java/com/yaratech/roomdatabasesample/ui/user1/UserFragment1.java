package com.yaratech.roomdatabasesample.ui.user1;

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
import com.yaratech.roomdatabasesample.data.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserFragment1 extends Fragment {

    List<User> users = new ArrayList<>();
    public static String USER_TAG1 = "user_fragment1";
    RecyclerView recyclerView;
    UserRecyclerViewAdapter1 userRecyclerViewAdapter;

    public UserFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.user_recyclerview);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userRecyclerViewAdapter = new UserRecyclerViewAdapter1(getContext());
        users = Arrays.asList((User[]) getArguments().getParcelableArray(USER_TAG1));
        userRecyclerViewAdapter.setUsers(users);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(userRecyclerViewAdapter);
    }

    public static UserFragment1 newInstance(User[] users) {

        Bundle args = new Bundle();
        args.putParcelableArray(USER_TAG1, users);
        UserFragment1 fragment = new UserFragment1();
        fragment.setArguments(args);
        return fragment;
    }
}
