package com.example.newsapp.ui.sourcelistscreen;

import android.view.View;

import com.example.newsapp.data.model.api.Source;
import com.example.newsapp.utils.Navigator;

/**
 * Created by Jayanth on 05/04/18.
 */

public class SourceActionHandler {

  public void showSourceInfo(View view, Source source) {
    Navigator.launchSourceDetail(view.getContext(), source.id);
  }
}
