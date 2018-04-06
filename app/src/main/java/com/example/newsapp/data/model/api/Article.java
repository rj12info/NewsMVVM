package com.example.newsapp.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Article POJO class against a given source id
 * Created by Jayanth on 05/04/18.
 */

public class Article implements Parcelable {
  public String author;
  public String title;
  public String description;
  public String url;
  public String urlToImage;
  public String publishedAt;

  protected Article(Parcel in) {
    author = in.readString();
    title = in.readString();
    description = in.readString();
    url = in.readString();
    urlToImage = in.readString();
    publishedAt = in.readString();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(author);
    dest.writeString(title);
    dest.writeString(description);
    dest.writeString(url);
    dest.writeString(urlToImage);
    dest.writeString(publishedAt);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<Article> CREATOR = new Creator<Article>() {
    @Override
    public Article createFromParcel(Parcel in) {
      return new Article(in);
    }

    @Override
    public Article[] newArray(int size) {
      return new Article[size];
    }
  };
}
