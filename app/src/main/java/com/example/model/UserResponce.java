package com.example.model;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponce implements Parcelable {

    @SerializedName("Status")
    @Expose
    private Boolean status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("UsersList")
    @Expose
    private List<UsersList> usersList = null;
    public final static Parcelable.Creator<UserResponce> CREATOR = new Creator<UserResponce>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserResponce createFromParcel(Parcel in) {
            return new UserResponce(in);
        }

        public UserResponce[] newArray(int size) {
            return (new UserResponce[size]);
        }

    };

    protected UserResponce(Parcel in) {
        this.status = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.usersList, (com.example.model.UsersList.class.getClassLoader()));
    }

    public UserResponce() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<UsersList> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<UsersList> usersList) {
        this.usersList = usersList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(message);
        dest.writeList(usersList);
    }

    public int describeContents() {
        return 0;
    }

}