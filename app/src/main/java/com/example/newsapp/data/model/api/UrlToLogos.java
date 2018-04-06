package com.example.newsapp.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jayanth on 05/04/18.
 */

public class UrlToLogos implements Parcelable {
  private String small;
  private String medium;
  private String large;

  protected UrlToLogos(Parcel in) {
    small = in.readString();
    medium = in.readString();
    large = in.readString();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(small);
    dest.writeString(medium);
    dest.writeString(large);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<UrlToLogos> CREATOR = new Creator<UrlToLogos>() {
    @Override
    public UrlToLogos createFromParcel(Parcel in) {
      return new UrlToLogos(in);
    }

    @Override
    public UrlToLogos[] newArray(int size) {
      return new UrlToLogos[size];
    }
  };
}
