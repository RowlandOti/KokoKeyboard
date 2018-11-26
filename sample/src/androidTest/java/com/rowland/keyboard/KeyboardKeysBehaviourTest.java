package com.rowland.keyboard;

import com.rowland.keyboard.sample.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class KeyboardKeysBehaviourTest {

    @Rule
    public ActivityTestRule<KeyboardActivity> mActivityRule = new ActivityTestRule<>(KeyboardActivity.class);
    private String mStringToBetyped;


    @Before
    public void setUp() {
        mStringToBetyped = "QWERTY";
    }

    @Test
    public void testSpaceAndBackSpaceKeys() {
        // Type text and then press the button.
        onView(withId(R.id.input_text)).perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.input_text)).check(matches(withText(mStringToBetyped)));

        onView(withId(R.id.key_backspace)).perform(longClick());
        // Check that the text was changed.
        onView(withId(R.id.input_text)).check(matches(not(withText(mStringToBetyped))));


        onView(allOf(withId(R.id.key_backspace))).check(matches(isDisplayed())).perform(longClick());
        // Check that the text was deleted
        onView(withId(R.id.input_text)).check(matches(withText("")));

        onView(allOf(withId(R.id.key_space))).check(matches(isDisplayed())).perform(click());
        // Check that the text was deleted
        onView(withId(R.id.input_text)).check(matches(withText(" ")));
    }
}
