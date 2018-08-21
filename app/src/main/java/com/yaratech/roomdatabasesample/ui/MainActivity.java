package com.yaratech.roomdatabasesample.ui;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.yaratech.roomdatabasesample.R;
import com.yaratech.roomdatabasesample.data.sourse.database.AppDatabase;
import com.yaratech.roomdatabasesample.ui.comment.CommentFragment;
import com.yaratech.roomdatabasesample.ui.post2.PostFragment2;
import com.yaratech.roomdatabasesample.ui.post1.PostFragment1;
import com.yaratech.roomdatabasesample.ui.user1.UserFragment1;
import com.yaratech.roomdatabasesample.ui.user2.UserFragment2;
import com.yaratech.roomdatabasesample.utility.DataGenerator;

import static com.yaratech.roomdatabasesample.ui.comment.CommentFragment.COMMENT_TAG;
import static com.yaratech.roomdatabasesample.ui.post1.PostFragment1.POST1_TAG;
import static com.yaratech.roomdatabasesample.ui.post2.PostFragment2.POST2_TAG;
import static com.yaratech.roomdatabasesample.ui.user1.UserFragment1.USER_TAG1;
import static com.yaratech.roomdatabasesample.ui.user2.UserFragment2.USER_TAG2;

public class MainActivity extends AppCompatActivity implements SetOnClickListener {
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(getApplicationContext());

        SharedPreferences ADD_DATABASE = getSharedPreferences("DATABASE", MODE_PRIVATE);


        if (ADD_DATABASE.getBoolean("DATABASE", true)) {

            presenter.generateUser();
            presenter.generatePost();
            presenter.generateComment();

            ADD_DATABASE.edit().putBoolean("DATABASE", false).apply();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.user1:
                                setFragment(
                                        R.id.frame,
                                        getSupportFragmentManager(),
                                        UserFragment1.newInstance(presenter.loadUser()),
                                        USER_TAG1,
                                        false);
                                break;

                            case R.id.user2:
                                setFragment(
                                        R.id.frame,
                                        getSupportFragmentManager(),
                                        UserFragment2.newInstance(presenter.loadUser()),
                                        USER_TAG2,
                                        false);
                                break;

                            case R.id.post1:
                                setFragment(
                                        R.id.frame,
                                        getSupportFragmentManager(),
                                        PostFragment1.newInstance(presenter.loadPost()),
                                        POST1_TAG,
                                        false);
                                break;

                            case R.id.post2:
                                setFragment(
                                        R.id.frame,
                                        getSupportFragmentManager(),
                                        PostFragment2.newInstance(presenter.loadPost()),
                                        POST2_TAG,
                                        false);
                                break;

                            case R.id.comment:
                                setFragment(
                                        R.id.frame,
                                        getSupportFragmentManager(),
                                        CommentFragment.newInstance(presenter.loadComment()),
                                        COMMENT_TAG,
                                        false);
                                break;
                        }

                        return false;
                    }
                });
    }

    public static void setFragment(int container, FragmentManager fragmentManager, Fragment fragment, String tag, boolean addToBackStack) {
        if (!fragment.isAdded()) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(container, fragment, tag);
            if (addToBackStack)
                fragmentTransaction.addToBackStack(tag);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onUserClick1(int id) {
        setFragment(
                R.id.frame,
                getSupportFragmentManager(),
                CommentFragment.newInstance(presenter.fetchCommentByUserId(id)),
                COMMENT_TAG,
                true);
    }

    @Override
    public void onUserClick2(int id) {
        setFragment(
                R.id.frame,
                getSupportFragmentManager(),
                PostFragment1.newInstance(presenter.fetchPostByUserId(id)),
                POST1_TAG,
                true);
    }

    @Override
    public void onPostClick1(int id) {
        setFragment(
                R.id.frame,
                getSupportFragmentManager(),
                CommentFragment.newInstance(presenter.fetchCommentByPostId(id)),
                COMMENT_TAG,
                true);
    }

    @Override
    public void onPostClick2(int id) {
        setFragment(
                R.id.frame,
                getSupportFragmentManager(),
                UserFragment1.newInstance(presenter.fetchUserByPostId(id)),
                USER_TAG1,
                true);
    }
}
