package com.example.model;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersList implements Parcelable {

    @SerializedName("UserTypeID")
    @Expose
    private String userTypeID;
    @SerializedName("UserLabel")
    @Expose
    private String userLabel;
    @SerializedName("Users")
    @Expose
    private List<User> users = null;
    public final static Parcelable.Creator<UsersList> CREATOR = new Creator<UsersList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UsersList createFromParcel(Parcel in) {
            return new UsersList(in);
        }

        public UsersList[] newArray(int size) {
            return (new UsersList[size]);
        }

    };

    protected UsersList(Parcel in) {
        this.userTypeID = ((String) in.readValue((String.class.getClassLoader())));
        this.userLabel = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.users, (com.example.model.User.class.getClassLoader()));
    }

    public UsersList() {
    }

    public String getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(String userTypeID) {
        this.userTypeID = userTypeID;
    }

    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userTypeID);
        dest.writeValue(userLabel);
        dest.writeList(users);
    }

    public int describeContents() {
        return 0;
    }

}