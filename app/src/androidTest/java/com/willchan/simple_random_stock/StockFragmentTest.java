package com.willchan.simple_random_stock;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

// Source: https://developer.android.com/training/testing/ui-testing/espresso-testing
@RunWith(AndroidJUnit4.class)
public class StockFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void generateRandomStock() {
        onView(withId(R.id.card_dow_jones)).perform(click());
        onView(allOf(withId(R.id.fragment_stock_cardview_parent), withId(R.id.congratulationsImageView)));
        onView(allOf(withId(R.id.fragment_stock_cardview_parent), withId(R.id.congratulationsTitle)));
        onView(allOf(withId(R.id.fragment_stock_cardview_parent), withId(R.id.stock_name_history)));
    }


}
