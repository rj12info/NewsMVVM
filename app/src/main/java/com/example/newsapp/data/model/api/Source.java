package com.example.newsapp.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Source POJO class
 * Created by Jayanth on 05/04/18.
 */

public class Source implements Parcelable {
  public String id;
  public String name;
  public String description;
  public String url;
  public String category;
  public String language;
  public String country;
  public UrlToLogos urlsToLogos;
  public ArrayList<String> sortBysAvailable;

  protected Source(Parcel in) {
    id = in.readString();
    name = in.readString();
    description = in.readString();
    url = in.readString();
    category = in.readString();
    language = in.readString();
    country = in.readString();
    urlsToLogos = in.readParcelable(UrlToLogos.class.getClassLoader());
    sortBysAvailable = in.createStringArrayList();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(id);
    dest.writeString(name);
    dest.writeString(description);
    dest.writeString(url);
    dest.writeString(category);
    dest.writeString(language);
    dest.writeString(country);
    dest.writeParcelable(urlsToLogos, flags);
    dest.writeStringList(sortBysAvailable);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<Source> CREATOR = new Creator<Source>() {
    @Override
    public Source createFromParcel(Parcel in) {
      return new Source(in);
    }

    @Override
    public Source[] newArray(int size) {
      return new Source[size];
    }
  };
}