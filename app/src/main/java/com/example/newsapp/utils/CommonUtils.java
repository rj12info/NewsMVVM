package com.example.newsapp.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.example.newsapp.R;

/**
 * Created by Jayanth on 21/02/18.
 */

public class CommonUtils {
  private CommonUtils() {

  }

  public static ProgressDialog showLoadingDialog(Context context) {
    ProgressDialog progressDialog = new ProgressDialog(context);
    progressDialog.show();
    if (progressDialog.getWindow() != null) {
      progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
    progressDialog.setContentView(R.layout.progress_dialog);
    progressDialog.setIndeterminate(true);
    progressDialog.setCancelable(false);
    progressDialog.setCanceledOnTouchOutside(false);
    return progressDialog;
  }

  public static String formatDate(String date) {
    return date;
  }
}
