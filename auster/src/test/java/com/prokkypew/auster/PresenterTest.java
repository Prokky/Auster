package com.prokkypew.auster;

import com.prokkypew.auster.utils.TestMvpView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class PresenterTest {

    private MvpPresenter presenter;
    private TestMvpView view;

    @Before
    public void beforeEachTest() {
        presenter = new MvpPresenter();
        view = new TestMvpView();
    }

    @Test
    public void attachView_shouldAttachViewToThePresenter() {
        presenter.attachView(view);
        assertSame(presenter.getMvpView(), view);
        assertNotNull(presenter.view());
    }

    @Test
    public void bindView_shouldThrowIfPreviousViewIsNotUnbounded() {
        presenter.attachView(view);
        Exception ex = null;
        try {
            presenter.attachView(new TestMvpView());
        } catch (Exception e) {
            ex = e;
        }
        assertNotNull(ex);
    }

    @Test
    public void checkViewAttach_shouldNotThrow() {
        presenter.attachView(view);
        Exception ex = null;
        try {
            presenter.checkViewAttached();
        } catch (MvpPresenter.MvpViewNotAttachedException e) {
            ex = e;
        }
        assertNull(ex);
    }

    @Test
    public void checkViewAttach_shouldThrow() {
        Exception ex = null;
        try {
            presenter.checkViewAttached();
        } catch (MvpPresenter.MvpViewNotAttachedException e) {
            ex = e;
        }
        assertNotNull(ex);
    }

    @Test
    public void view_shouldReturnNullByDefault() {
        assertNull(presenter.getMvpView());
    }

    @Test
    public void unbindView_shouldNullTheViewReference() {
        presenter.attachView(view);
        assertSame(presenter.getMvpView(), view);

        presenter.detachView(view);
        assertNull(presenter.getMvpView());
    }

    @Test
    public void unbindView_shouldThrowNotSameViewException() {
        presenter.attachView(view);
        assertSame(presenter.getMvpView(), view);


        Exception ex = null;
        try {
            presenter.detachView(new TestMvpView());
        } catch (MvpPresenter.UnexpectedMvpViewException e) {
            ex = e;
        }
        assertNotNull(ex);
    }
}