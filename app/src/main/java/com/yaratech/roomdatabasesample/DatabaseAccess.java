package com.yaratech.roomdatabasesample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.yaratech.roomdatabasesample.model.Comment;
import com.yaratech.roomdatabasesample.model.Post;
import com.yaratech.roomdatabasesample.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vah on 8/20/2018.
 */

@Dao
public interface DatabaseAccess{

    @Insert
    void insertUser(User... user);

    @Insert
    void insertPost(Post... post);

    @Insert
    void insertComment(Comment... comment);

    @Query("SELECT * " +
            "FROM Comment " +
            "JOIN User " +
            "ON Comment.userId = User.id " +
            "WHERE User.id = :userId")
    Comment[] fetchCommentByUserId(int userId);

    @Query("SELECT * " +
            "FROM Post " +
            "JOIN Comment " +
            "ON Post.id = Comment.postId " +
            "JOIN User " +
            "ON Comment.userId = User.id " +
            "WHERE User.id = :userId")
    Post[] fetchPostByUserId(int userId);

    @Query("SELECT * " +
            "FROM Comment " +
            "JOIN Post " +
            "ON Comment.postId = Post.id " +
            "WHERE Post.id = :postId")
    Comment[] fetchCommentByPostId(int postId);

    @Query("SELECT * " +
            "FROM User " +
            "JOIN Comment " +
            "ON User.id = Comment.userId " +
            "JOIN Post " +
            "ON Post.id = Comment.postId " +
            "WHERE Post.id = :postId")
    User[] fetchUserByPostId(int postId);

    @Query("SELECT * " +
            "FROM User")
    User[] loadUser();

    @Query("SELECT * " +
            "FROM Post")
    Post[] loadPost();

    @Query("SELECT * " +
            "FROM Comment")
    Comment[] loadComment();
}
