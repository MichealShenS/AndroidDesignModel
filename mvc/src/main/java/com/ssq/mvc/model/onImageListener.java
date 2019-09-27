package com.ssq.mvc.model;

import okhttp3.Response;

/**
 * Author : Mr.Shen
 * Date : 2019/9/27 19:52
 * Description :
 */
public interface onImageListener {

    void onSuccess(Response response);

    void onError();
}
