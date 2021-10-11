package com.fizzbuzz.app.game

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.fizzbuzz.app.R
import com.fizzbuzz.app.presentation.game.form.FormGameFragment
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormGameFragmentTest {


    @Test
    fun testEmptyForm() {
        //given
        launchFragmentInContainer<FormGameFragment>(themeResId = R.style.Theme_FizzBuzz)

        //when
        onView(withId(R.id.result)).perform(click())

        //then
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(R.string.fill_all_fields_message)))
    }

    @Test
    fun testEnterSameInt1AndInt2ShowError() {
        //given
        launchFragmentInContainer<FormGameFragment>(themeResId = R.style.Theme_FizzBuzz)

        onView(withId(R.id.first_integer)).perform(clearText() , typeText("3"))
        onView(withId(R.id.second_integer)).perform(clearText() , typeText("3"))
        onView(withId(R.id.limit)).perform(clearText() , typeText("100"))
        onView(withId(R.id.first_string)).perform(clearText() , typeText("fizz"))
        onView(withId(R.id.second_string)).perform(clearText() , typeText("buzz"), closeSoftKeyboard())

        //when
        onView(withId(R.id.result)).perform(click())

        //Then
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(R.string.put_different_integer_message)))
    }

    @Test
    fun testClickShowResultLeadToResultScreen() {
        //given
        val scenario = launchFragmentInContainer<FormGameFragment>(Bundle(), R.style.Theme_FizzBuzz)
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        scenario.onFragment {
            navController.setGraph(R.navigation.nav_graph)
            navController.setCurrentDestination(R.id.formGameScreen)
            Navigation.setViewNavController(it.requireView(), navController)
        }

        onView(withId(R.id.first_integer)).perform(clearText() , typeText("3"))
        onView(withId(R.id.second_integer)).perform(clearText() , typeText("5"))
        onView(withId(R.id.limit)).perform(clearText() , typeText("100"))
        onView(withId(R.id.first_string)).perform(clearText() , typeText("fizz"))
        onView(withId(R.id.second_string)).perform(clearText() , typeText("buzz"), closeSoftKeyboard())

        //when
        onView(withId(R.id.result)).perform(click())

        //then
       assertEquals(navController.currentDestination?.id, R.id.resultGameScreen)

    }
}