package com.ssq.mvp.contract;

import com.ssq.mvp.base.BaseView;
import com.ssq.mvp.bean.BaseObjectBean;
import com.ssq.mvp.bean.LoginBean;

import io.reactivex.Flowable;

/**
 * Author : Mr.Shen
 * Date : 2019/9/28 11:29
 * Description :
 */
public class MainContract {

    public interface Model {
        Flowable<BaseObjectBean<LoginBean>> login(String userName, String passWord);
    }

    public interface View extends BaseView {

        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BaseObjectBean<LoginBean> bean);
    }

    public interface Presenter {

        /**
         * 登陆
         *
         * @param userName
         * @param passWord
         */
        void login(String userName, String passWord);
    }
}
