package com.willchan.simple_random_stock;

import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class HistoryFragmentTest {
    private static final String TAG = "HistoryFragmentTest";

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    // TODO: Don't know how to write this test.
    @Test
    public void selectRandomStockAndDeleteFromHistory() throws InterruptedException {
//        onView(withId(R.id.card_dow_jones)).perform(click());
//        onView(allOf(withId(R.id.stock_name_created))).wait();
//        TextView textView = activityTestRule.getActivity().findViewById(R.id.stock_name_created);


    }
}
