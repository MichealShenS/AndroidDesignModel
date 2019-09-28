package com.ssq.mvp.model;

import com.ssq.mvp.contract.MainContract;
import com.ssq.mvp.bean.BaseObjectBean;
import com.ssq.mvp.bean.LoginBean;
import com.ssq.mvp.net.RetrofitClient;

import io.reactivex.Flowable;

/**
 * Author : Mr.Shen
 * Date : 2019/9/28 11:35
 * Description :
 */
public class MainModel implements MainContract.Model {
    @Override
    public Flowable<BaseObjectBean<LoginBean>> login(String userName, String passWord) {
        return RetrofitClient.getInstance().getApi().login(userName,passWord);
    }
}
