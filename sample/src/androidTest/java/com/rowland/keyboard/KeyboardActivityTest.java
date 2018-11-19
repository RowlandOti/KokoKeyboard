package com.rowland.keyboard;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.rowland.keyboard.sample.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class KeyboardActivityTest {

    @Rule
    public ActivityTestRule<KeyboardActivity> mActivityTestRule = new ActivityTestRule<>(KeyboardActivity.class);

    private static Matcher<View> childAtPosition(
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

    @Test
    public void keyboardActivityTest() {
        ViewInteraction squareKeyView = onView(
                allOf(withId(R.id.key_q), withText("Q"),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_qwerty_one),
                                        childAtPosition(
                                                withId(R.id.keyboard_wrapper_layout),
                                                1)),
                                0),
                        isDisplayed()));
        squareKeyView.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.input_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("Q"), closeSoftKeyboard());

        ViewInteraction squareKeyView2 = onView(
                allOf(withId(R.id.key_w), withText("W"),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_qwerty_one),
                                        childAtPosition(
                                                withId(R.id.keyboard_wrapper_layout),
                                                1)),
                                1),
                        isDisplayed()));
        squareKeyView2.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.input_text), withText("Q"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("QW"));

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.input_text), withText("QW"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(closeSoftKeyboard());

        ViewInteraction squareKeyView3 = onView(
                allOf(withId(R.id.key_e), withText("E"),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_qwerty_one),
                                        childAtPosition(
                                                withId(R.id.keyboard_wrapper_layout),
                                                1)),
                                2),
                        isDisplayed()));
        squareKeyView3.perform(click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.input_text), withText("QW"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(replaceText("QWE"));

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.input_text), withText("QWE"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(closeSoftKeyboard());

        ViewInteraction squareKeyView4 = onView(
                allOf(withId(R.id.key_r), withText("R"),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_qwerty_one),
                                        childAtPosition(
                                                withId(R.id.keyboard_wrapper_layout),
                                                1)),
                                3),
                        isDisplayed()));
        squareKeyView4.perform(click());

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.input_text), withText("QWE"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText6.perform(replaceText("QWER"));

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.input_text), withText("QWER"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText7.perform(closeSoftKeyboard());

        ViewInteraction squareKeyView5 = onView(
                allOf(withId(R.id.key_t), withText("T"),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_qwerty_one),
                                        childAtPosition(
                                                withId(R.id.keyboard_wrapper_layout),
                                                1)),
                                4),
                        isDisplayed()));
        squareKeyView5.perform(click());

        ViewInteraction textInputEditText8 = onView(
                allOf(withId(R.id.input_text), withText("QWER"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText8.perform(replaceText("QWERT"));

        ViewInteraction textInputEditText9 = onView(
                allOf(withId(R.id.input_text), withText("QWERT"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText9.perform(closeSoftKeyboard());

        ViewInteraction squareKeyView6 = onView(
                allOf(withId(R.id.key_y), withText("Y"),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_qwerty_one),
                                        childAtPosition(
                                                withId(R.id.keyboard_wrapper_layout),
                                                1)),
                                5),
                        isDisplayed()));
        squareKeyView6.perform(click());

        ViewInteraction textInputEditText10 = onView(
                allOf(withId(R.id.input_text), withText("QWERT"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText10.perform(replaceText("QWERTY"));

        ViewInteraction textInputEditText11 = onView(
                allOf(withId(R.id.input_text), withText("QWERTY"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText11.perform(closeSoftKeyboard());

        ViewInteraction editText = onView(
                allOf(withId(R.id.input_text), withText("QWERTY"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        editText.check(matches(withText("QWERTY")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.input_text), withText("QWERTY"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.textinput_layout),
                                        0),
                                0),
                        isDisplayed()));
        editText2.check(matches(withText("QWERTY")));

        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.keyboard_row_num),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_wrapper_layout),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));

        ViewInteraction linearLayout2 = onView(
                allOf(withId(R.id.keyboard_qwerty_two),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_wrapper_layout),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                2),
                        isDisplayed()));
        linearLayout2.check(matches(isDisplayed()));

        ViewInteraction button = onView(
                allOf(withId(R.id.key_backspace),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_qwerty_one),
                                        childAtPosition(
                                                withId(R.id.keyboard_wrapper_layout),
                                                1)),
                                10),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.key_space),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_qwerty_four),
                                        childAtPosition(
                                                withId(R.id.keyboard_wrapper_layout),
                                                4)),
                                0),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.key_space),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_qwerty_four),
                                        childAtPosition(
                                                withId(R.id.keyboard_wrapper_layout),
                                                4)),
                                0),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        ViewInteraction linearLayout3 = onView(
                allOf(withId(R.id.keyboard_qwerty_four),
                        childAtPosition(
                                allOf(withId(R.id.keyboard_wrapper_layout),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                3),
                        isDisplayed()));
        linearLayout3.check(matches(isDisplayed()));
    }
}
