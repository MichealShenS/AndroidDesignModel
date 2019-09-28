package com.ssq.mvp.net;

import com.ssq.mvp.bean.BaseObjectBean;
import com.ssq.mvp.bean.LoginBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Author : Mr.Shen
 * Date : 2019/9/28 11:37
 * Description :
 */
public interface ApiServiece {

    /**
     * 登陆
     *
     * @param userName 账号
     * @param passWord 密码
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Flowable<BaseObjectBean<LoginBean>> login(@Field("userName") String userName,
                                              @Field("passWord") String passWord);
}
