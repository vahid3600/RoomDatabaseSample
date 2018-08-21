package com.yaratech.roomdatabasesample.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vah on 8/20/2018.
 */

@Entity (tableName = "Post")
public class Post implements Parcelable{

    @PrimaryKey
    private int id;
    private String title;
    private String description;
    private String image;
    private int userId;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUserId() {
        return userId;

    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static Creator<Post> getCREATOR() {
        return CREATOR;
    }

    public Post(){}

    protected Post(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        image = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return image;
    }

    public void setAvatar(String avatar) {
        this.image = avatar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(image);
    }
}
