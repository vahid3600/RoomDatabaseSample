package com.yaratech.roomdatabasesample.utility;

import com.yaratech.roomdatabasesample.database.AppDatabase;
import com.yaratech.roomdatabasesample.model.Comment;
import com.yaratech.roomdatabasesample.model.Post;
import com.yaratech.roomdatabasesample.model.User;

/**
 * Created by Vah on 8/20/2018.
 */

public class DataGenerator {

    private static AppDatabase dataBase;
    private static DataGenerator instance;

    public static DataGenerator with(AppDatabase appDatabase) {

        if (dataBase == null)
            dataBase = appDatabase;

        if (instance == null)
            instance = new DataGenerator();

        return instance;
    }

    public void generateUser() {
        if (dataBase == null)
            return;

        User[] users = new User[6];

        users[0] = userInstance(1, "vahid", "vahidi", 123);
        users[1] = userInstance(2, "saeed", "saeedi", 456);
        users[2] = userInstance(3, "reza", "rezaii", 789);
        users[3] = userInstance(4, "mohamad", "mohamadi", 147);
        users[4] = userInstance(5, "sara", "vahidi", 258);
        users[5] = userInstance(6, "elham", "mohamadi", 369);

        dataBase.databaseAccess().insertUser(users);
    }

    private User userInstance(int id, String name, String familyName, int nationalCode) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setFamilyName(familyName);
        user.setNationalCode(nationalCode);
        return user;
    }

    public void generatePost() {
        if (dataBase == null)
            return;

        Post[] posts = new Post[6];

        posts[0] = postInstance(1, "gol", "gol che khoobe", "");
        posts[1] = postInstance(2, "bolbol", "bolbolam khoobe", "");
        posts[2] = postInstance(3, "derakht", "unam khoobe", "");
        posts[3] = postInstance(4, "doshman", "in na ziad", "");
        posts[4] = postInstance(5, "yaratube", "kheiliam awli", "");
        posts[5] = postInstance(6, "gorbe", "nice", "");

        dataBase.databaseAccess().insertPost(posts);
    }

    private Post postInstance(int id, String title, String description, String avatar) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setDescription(description);
        post.setAvatar(avatar);
        return post;
    }

    public void generateComment() {
        if (dataBase == null)
            return;

        Comment[] comments = new Comment[15];

        comments[0] = commentInstance(1, 1, "ajab", 1);
        comments[1] = commentInstance(2, 1, "bah bah", 4);
        comments[2] = commentInstance(3, 1, "akhey", 6);
        comments[3] = commentInstance(4, 2, "eee", 2);
        comments[4] = commentInstance(5, 2, "aha", 1);
        comments[5] = commentInstance(6, 2, "heh heh", 5);
        comments[6] = commentInstance(7, 3, "hmmm", 2);
        comments[7] = commentInstance(8, 3, ":D", 6);
        comments[8] = commentInstance(9, 4, ":O", 6);
        comments[9] = commentInstance(10, 4, ":(", 6);
        comments[10] = commentInstance(11, 4, "ey baba", 3);
        comments[11] = commentInstance(12, 4, "dorud", 5);
        comments[12] = commentInstance(13, 5, "khandidam", 2);
        comments[13] = commentInstance(14, 5, "dorughe", 1);
        comments[14] = commentInstance(15, 6, "che jaleb", 3);

        dataBase.databaseAccess().insertComment(comments);
    }

    private Comment commentInstance(int id, int userId, String commentText, int postId) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUserId(userId);
        comment.setComment(commentText);
        comment.setPostId(postId);
        return comment;
    }
}
