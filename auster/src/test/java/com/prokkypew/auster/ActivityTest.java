package com.prokkypew.auster;

import com.prokkypew.auster.utils.TestActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by alexander_roman on 26.07.16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class ActivityTest {

    private ActivityController<TestActivity> controller;

    @Before
    public void setUp() {
        controller = Robolectric.buildActivity(TestActivity.class).create();//.resume();
    }

    @Test
    public void presenter_ViewShouldNotBeNull() {
        TestActivity activity = controller.get();
        assertNotNull(activity.presenter);
        assertNotNull(activity.presenter.view());
    }

    @Test
    public void presenter_ViewShouldBeNull() {
        TestActivity activity = controller.pause().destroy().get();
        assertNotNull(activity.presenter);
        assertNull(activity.presenter.view());
    }
}
