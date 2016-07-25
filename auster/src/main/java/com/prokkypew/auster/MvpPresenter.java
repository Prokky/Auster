package com.prokkypew.auster;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

/**
 * Created by alexander_roman on 30.05.16.
 * <p/>
 */
public class MvpPresenter<V extends MvpView> {

    @Nullable
    private volatile V mvpView;

    @CallSuper
    public void attachView(V mvpView) {
        final V prevView = this.mvpView;
        if (prevView != null) {
            throw new MvpViewNotDetachedException();
        }
        this.mvpView = mvpView;
    }

    @CallSuper
    public void detachView() {
        final V prevView = this.mvpView;

        if (prevView == mvpView) {
            this.mvpView = null;
        } else {
            throw new UnexpectedMvpViewException(mvpView);
        }
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    @Nullable
    public V getMvpView() {
        return mvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached())
            throw new MvpViewNotAttachedException();
    }

    @Nullable
    protected V view() {
        return mvpView;
    }

    public static class UnexpectedMvpViewException extends IllegalStateException {
        public UnexpectedMvpViewException(MvpView mvpView) {
            super("Unexpected view to detach. Expected " + mvpView);
        }
    }

    public static class MvpViewNotDetachedException extends IllegalStateException {
        public MvpViewNotDetachedException() {
            super("Please detach MvpView before attaching new");
        }
    }

    public static class MvpViewNotAttachedException extends IllegalStateException {
        public MvpViewNotAttachedException() {
            super("Please attach MvpView first");
        }
    }
}

