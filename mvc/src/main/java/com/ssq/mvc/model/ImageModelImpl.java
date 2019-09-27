package com.ssq.mvc.model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author : Mr.Shen
 * Date : 2019/9/27 19:51
 * Description : 从网络获取图片接口实现
 */
public class ImageModelImpl implements ImageModel {

    @Override
    public void getImage(final onImageListener listener) {

        /*数据层操作*/
        new OkHttpClient().newCall(new Request.Builder().url("https://www.baidu.com/img/bd_logo1.png").get().build()).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                listener.onError();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                listener.onSuccess(response);
            }
        });

    }
}
