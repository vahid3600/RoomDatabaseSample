package com.yaratech.roomdatabasesample.ui;

import android.content.Context;

import com.yaratech.roomdatabasesample.data.model.Comment;
import com.yaratech.roomdatabasesample.data.model.Post;
import com.yaratech.roomdatabasesample.data.model.User;
import com.yaratech.roomdatabasesample.data.sourse.Repository;

/**
 * Created by Vah on 8/21/2018.
 */

public class MainPresenter implements MainContract.Presenter {

    private Repository repository;

    public MainPresenter(Context context){
        repository = new Repository(context);
    }

    @Override
    public void generateUser() {
        repository.generateUser();
    }

    @Override
    public void generatePost() {
        repository.generatePost();
    }

    @Override
    public void generateComment() {
        repository.generateComment();
    }

    @Override
    public User[] loadUser() {
        return repository.loadUser();
    }

    @Override
    public Post[] loadPost() {
        return repository.loadPost();
    }

    @Override
    public Comment[] loadComment() {
        return repository.loadComment();
    }

    @Override
    public Comment[] fetchCommentByUserId(int id) {
        return repository.fetchCommentByUserId(id);
    }

    @Override
    public Post[] fetchPostByUserId(int id) {
        return repository.fetchPostByUserId(id);
    }

    @Override
    public Comment[] fetchCommentByPostId(int id) {
        return repository.fetchCommentByPostId(id);
    }

    @Override
    public User[] fetchUserByPostId(int id) {
        return repository.fetchUserByPostId(id);
    }
}
