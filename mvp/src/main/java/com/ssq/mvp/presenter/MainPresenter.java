package com.ssq.mvp.presenter;

import com.ssq.mvp.contract.MainContract;
import com.ssq.mvp.model.MainModel;
import com.ssq.mvp.base.BasePresenter;
import com.ssq.mvp.bean.BaseObjectBean;
import com.ssq.mvp.bean.LoginBean;
import com.ssq.mvp.net.RxScheduler;

import io.reactivex.functions.Consumer;

/**
 * Author : Mr.Shen
 * Date : 2019/9/28 15:11
 * Description :
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainContract.Model model;

    public MainPresenter() {
        model = new MainModel();
    }

    @Override
    public void login(String userName, String passWord) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.login(userName, passWord)
                .compose(RxScheduler.<BaseObjectBean<LoginBean>>Flo_io_main())
                .as(mView.bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<LoginBean>>() {
                    @Override
                    public void accept(BaseObjectBean<LoginBean> beanBaseObjectBean) throws Exception {
                        mView.onSuccess(beanBaseObjectBean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }
}
