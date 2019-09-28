package com.ssq.mvp.base;

/**
 * Author : Mr.Shen
 * Date : 2019/9/28 11:22
 * Description :
 */
public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    protected T mPresenter;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
