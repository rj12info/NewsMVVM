package com.example.newsapp.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Jayanth on 05/04/18.
 */

public class SourceDetailResponse implements Parcelable {
  public String source;
  public String sortBy;
  public ArrayList<Article> articles;

  protected SourceDetailResponse(Parcel in) {
    source = in.readString();
    sortBy = in.readString();
    articles = in.createTypedArrayList(Article.CREATOR);
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(source);
    dest.writeString(sortBy);
    dest.writeTypedList(articles);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<SourceDetailResponse> CREATOR = new Creator<SourceDetailResponse>() {
    @Override
    public SourceDetailResponse createFromParcel(Parcel in) {
      return new SourceDetailResponse(in);
    }

    @Override
    public SourceDetailResponse[] newArray(int size) {
      return new SourceDetailResponse[size];
    }
  };
}
