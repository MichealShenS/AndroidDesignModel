package com.ssq.mvp.base;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;

/**
 * Author : Mr.Shen
 * Date : 2019/9/28 11:11
 * Description :
 */
public interface BaseView {

    /**
     * 显示加载中
     */
    void showLoading();

    /**
     * 隐藏加载中
     */
    void hideLoading();

    /**
     * 数据获取失败
     *
     * @param throwable
     */
    void onError(Throwable throwable);

    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     *
     * @param <T>
     * @return
     */
    <T> AutoDisposeConverter<T> bindAutoDispose();

}
