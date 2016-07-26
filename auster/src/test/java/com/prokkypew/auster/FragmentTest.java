package com.prokkypew.auster;

import com.prokkypew.auster.utils.TestFragment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by alexander_roman on 26.07.16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class FragmentTest {

    @Test
    public void presenter_ViewShouldNotBeNull() {
        TestFragment fragment = new TestFragment();
        SupportFragmentTestUtil.startFragment(fragment);
        fragment.onViewCreated(null, null);
        assertNotNull(fragment.presenter);
    }

    @Test
    public void presenter_ViewShouldBeNull() {
        TestFragment fragment = new TestFragment();
        SupportFragmentTestUtil.startFragment(fragment);
        fragment.onViewCreated(null, null);
        fragment.onDestroyView();
        assertNotNull(fragment.presenter);
        assertNull(fragment.presenter.view());
    }
}
