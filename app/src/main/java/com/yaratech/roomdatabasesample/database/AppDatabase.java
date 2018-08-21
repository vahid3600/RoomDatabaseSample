package com.yaratech.roomdatabasesample.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.yaratech.roomdatabasesample.DatabaseAccess;
import com.yaratech.roomdatabasesample.model.Comment;
import com.yaratech.roomdatabasesample.model.Post;
import com.yaratech.roomdatabasesample.model.User;

/**
 * Created by Vah on 8/20/2018.
 */

@Database(entities = {
        User.class,
        Post.class,
        Comment.class},
        version = 1,
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static String DATABASE_NAME = "SampleDatabase";
    private static AppDatabase appDatabase;

    public abstract DatabaseAccess databaseAccess();

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "SampleDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }
}
