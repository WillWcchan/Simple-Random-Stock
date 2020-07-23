package com.willchan.simple_random_stock;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.SmallTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class);

    public static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @SmallTest
    @Test
    public void mainActivityDisplayed() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()));
    }

    @SmallTest
    @Test
    public void dowJonesCardViewDisplayed() {
        onView(withId(R.id.card_dow_jones)).check(matches(isDisplayed()));
    }

    @SmallTest
    @Test
    public void spyCardViewDisplayed() {
        onView(withId(R.id.card_spy500)).check(matches(isDisplayed()));
    }

    @SmallTest
    @Test
    public void nasdaqCardViewDisplayed() {
        onView(withId(R.id.card_nasdaq)).check(matches(isDisplayed()));
    }

    @SmallTest
    @Test
    public void dowJonesCardViewTextDisplayed() {
        ViewInteraction textView = onView(
                allOf(withText("DOW JONES 30"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("DOW JONES 30")));
    }

    @SmallTest
    @Test
    public void spyCardViewTextDisplayed() {
        ViewInteraction textView2 = onView(
                allOf(withText("S&P 500"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("S&P 500")));
    }

//    @SmallTest
//    @Test
//    public void clickDowCardAndSeeRandomStockGenerated() throws InterruptedException {
//        onView(withId(R.id.card_dow_jones)).perform(click());
//        Thread.sleep(3000);
//        onView(withId(R.id.card)).check(matches(isDisplayed()));
//        onView(withId(R.id.congratulationsImageView)).check(matches(isDisplayed()));
//        onView(withId(R.id.congratulationsTitle)).check(matches(withText(R.string.congratulations)));
//    }

    @SmallTest
    @Test
    public void nasdaqViewTextDisplayed() {
        ViewInteraction textView3 = onView(
                allOf(withText("NASDAQ 100"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("NASDAQ 100")));
    }
}