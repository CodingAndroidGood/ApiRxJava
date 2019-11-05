package com.example.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("ListUserID")
    @Expose
    private String listUserID;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("UserCategory")
    @Expose
    private Object userCategory;
    @SerializedName("UserImage")
    @Expose
    private String userImage;
    @SerializedName("IsFollow")
    @Expose
    private Boolean isFollow;
    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
                "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    };

    protected User(Parcel in) {
        this.listUserID = ((String) in.readValue((String.class.getClassLoader())));
        this.userName = ((String) in.readValue((String.class.getClassLoader())));
        this.userCategory = ((Object) in.readValue((Object.class.getClassLoader())));
        this.userImage = ((String) in.readValue((String.class.getClassLoader())));
        this.isFollow = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public User() {
    }

    public String getListUserID() {
        return listUserID;
    }

    public void setListUserID(String listUserID) {
        this.listUserID = listUserID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Object getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(Object userCategory) {
        this.userCategory = userCategory;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Boolean getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(Boolean isFollow) {
        this.isFollow = isFollow;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(listUserID);
        dest.writeValue(userName);
        dest.writeValue(userCategory);
        dest.writeValue(userImage);
        dest.writeValue(isFollow);
    }

    public int describeContents() {
        return 0;
    }

}