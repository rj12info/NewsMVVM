package com.example.newsapp.utils;

import android.content.Context;
import android.content.Intent;

import com.example.newsapp.ui.sourcedetailscreen.NewsSourceDetailActivity;

/**
 * Created by Jayanth on 05/04/18.
 */

public class Navigator {
  private Navigator() {

  }

  public static void launchSourceDetail(Context context, String sourceId) {
    Intent intent = new Intent(context, NewsSourceDetailActivity.class);
    intent.putExtra(AppConstants.SOURCE_ID, sourceId);
    context.getApplicationContext().startActivity(intent);
  }
}
