package com.yaratech.roomdatabasesample.ui;

import com.yaratech.roomdatabasesample.data.model.Comment;
import com.yaratech.roomdatabasesample.data.model.Post;
import com.yaratech.roomdatabasesample.data.model.User;

/**
 * Created by Vah on 8/21/2018.
 */

public interface MainContract {

    public interface View{

    }

    public interface Presenter{
        void generateUser();

        void generatePost();

        void generateComment();

        User[] loadUser();

        Post[] loadPost();

        Comment[] loadComment();

        Comment[] fetchCommentByUserId(int id);

        Post[] fetchPostByUserId(int id);

        Comment[] fetchCommentByPostId(int id);

        User[] fetchUserByPostId(int id);
    }
}
