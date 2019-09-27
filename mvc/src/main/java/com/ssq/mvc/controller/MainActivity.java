package com.ssq.mvc.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ssq.mvc.R;
import com.ssq.mvc.model.onImageListener;
import com.ssq.mvc.model.ImageModelImpl;

import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements onImageListener {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.imageView)
    ImageView imageView;

    ImageModelImpl imageModelImpl;
    Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        button = findViewById(R.id.button);
//        imageView = findViewById(R.id.imageView);
        imageModelImpl = new ImageModelImpl();
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setTitle("正在加载图片...");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.show();
                imageModelImpl.getImage(MainActivity.this);
            }
        });
    }


    @Override
    public void onSuccess(Response response) {
        loadingDialog.dismiss();
        try {
            InputStream inputStream = response.body().byteStream();
            final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(bitmap);
                }
            });
        } catch (Exception e) {

        }
    }

    @Override
    public void onError() {
        loadingDialog.dismiss();
        Toast.makeText(this, "图片获取失败", Toast.LENGTH_SHORT).show();
    }
}
