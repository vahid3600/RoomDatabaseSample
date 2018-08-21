package com.yaratech.roomdatabasesample.data.sourse;

import android.content.Context;

import com.yaratech.roomdatabasesample.data.model.Comment;
import com.yaratech.roomdatabasesample.data.model.Post;
import com.yaratech.roomdatabasesample.data.model.User;
import com.yaratech.roomdatabasesample.data.sourse.database.AppDatabase;
import com.yaratech.roomdatabasesample.utility.DataGenerator;

/**
 * Created by Vah on 8/21/2018.
 */

public class Repository {
    AppDatabase appDatabase;

    public Repository(Context context) {
        appDatabase = AppDatabase.getAppDatabase(context);
    }

    public void generateUser() {
        DataGenerator.with(appDatabase).generateUser();
    }

    public void generatePost(){
        DataGenerator.with(appDatabase).generatePost();
    }

    public void generateComment(){
        DataGenerator.with(appDatabase).generateComment();
    }

    public User[] loadUser(){
        return appDatabase.databaseAccess().loadUser();
    }

    public Post[] loadPost(){
        return appDatabase.databaseAccess().loadPost();
    }

    public Comment[] loadComment(){
        return appDatabase.databaseAccess().loadComment();
    }

    public Comment[] fetchCommentByUserId(int id){
        return appDatabase.databaseAccess().fetchCommentByUserId(id);
    }

    public Post[] fetchPostByUserId(int id){
        return appDatabase.databaseAccess().fetchPostByUserId(id);
    }

    public Comment[] fetchCommentByPostId(int id){
        return appDatabase.databaseAccess().fetchCommentByPostId(id);
    }

    public User[] fetchUserByPostId(int id){
        return appDatabase.databaseAccess().fetchUserByPostId(id);
    }
}
