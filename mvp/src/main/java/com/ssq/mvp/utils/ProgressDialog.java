package com.ssq.mvp.utils;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Author : Mr.Shen
 * Date : 2019/9/28 14:19
 * Description : 圆形进度条Dialog
 */
public class ProgressDialog {

    private static volatile ProgressDialog instance;

    public ProgressDialog() {

    }

    public static ProgressDialog getInstance() {
        if (instance == null) {
            synchronized (ProgressDialog.class) {
                if (instance == null) {
                    instance = new ProgressDialog();
                }
            }
        }
        return instance;
    }

    private MaterialDialog materialDialog;

    public void show(Context mContext) {
        materialDialog = new MaterialDialog.Builder(mContext)
                .title("")
                .content("")
                .progress(true, 0)
                .cancelable(false)
                .progressIndeterminateStyle(false)
                .show();

    }

    public void dismiss() {
        materialDialog.dismiss();
    }
}
