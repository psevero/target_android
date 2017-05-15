package com.curso.target.aula6;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.afollestad.materialdialogs.MaterialDialog;

import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sala01 on 15/05/2017.
 */


public class DownloadImage extends AsyncTask<String, Integer, Bitmap> {
    private Context context;
    private  MaterialDialog materialDialog;
    private DownloadListener listener;
    private ProgressBar progressBar;

    public DownloadImage(Context context, ProgressBar progressBar, DownloadListener listener) {
        this.context = context;
        this.listener = listener;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("mLog", "onPre");
        //Codigo
//        materialDialog = new MaterialDialog.Builder(context)
//                .progress(true, 0)
//                .cancelable(false)
//                .show();
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        Log.d("mLog", "onBack");
        //Codigo
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("https://firebase.google.com/images/homepage/grow_1x.png")
                .build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null) {
            InputStream inputStream = response.body().byteStream();
            return BitmapFactory.decodeStream(inputStream);


        } else {
            return null;
        }
    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Log.d("mLog", "onPost");
        progressBar.setVisibility(View.GONE);

        if (bitmap != null) {
            listener.getImg(bitmap);
        }
       // materialDialog.dismiss();
    }

    protected void onProgressUpdate(Integer params) {
        //Codigo
    }


}
