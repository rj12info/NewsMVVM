package com.example.newsapp.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * POJO class for deserializing response
 * Created by Jayanth on 05/04/18.
 */

public class SourceListResponse implements Parcelable {
  public ArrayList<Source> sources;

  protected SourceListResponse(Parcel in) {
    sources = in.createTypedArrayList(Source.CREATOR);
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeTypedList(sources);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<SourceListResponse> CREATOR = new Creator<SourceListResponse>() {
    @Override
    public SourceListResponse createFromParcel(Parcel in) {
      return new SourceListResponse(in);
    }

    @Override
    public SourceListResponse[] newArray(int size) {
      return new SourceListResponse[size];
    }
  };
}
