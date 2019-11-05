package com.example.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLoginDetails implements Parcelable {

    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("AccessToken")
    @Expose
    private String accessToken;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ProfileImage")
    @Expose
    private String profileImage;
    @SerializedName("UserType")
    @Expose
    private String userType;
    @SerializedName("CountryName")
    @Expose
    private String countryName;
    public final static Parcelable.Creator<UserLoginDetails> CREATOR = new Creator<UserLoginDetails>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserLoginDetails createFromParcel(Parcel in) {
            return new UserLoginDetails(in);
        }

        public UserLoginDetails[] newArray(int size) {
            return (new UserLoginDetails[size]);
        }

    };

    protected UserLoginDetails(Parcel in) {
        this.userID = ((String) in.readValue((String.class.getClassLoader())));
        this.accessToken = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.profileImage = ((String) in.readValue((String.class.getClassLoader())));
        this.userType = ((String) in.readValue((String.class.getClassLoader())));
        this.countryName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserLoginDetails() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userID);
        dest.writeValue(accessToken);
        dest.writeValue(name);
        dest.writeValue(profileImage);
        dest.writeValue(userType);
        dest.writeValue(countryName);
    }

    public int describeContents() {
        return 0;
    }

}