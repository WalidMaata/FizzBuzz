package com.fizzbuzz.app.game

import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.fizzbuzz.app.*
import com.fizzbuzz.app.data.model.FizzBuzz
import com.fizzbuzz.app.presentation.game.result.ResultGameFragment
import com.fizzbuzz.app.utils.RecyclerViewMatcher
import com.fizzbuzz.app.utils.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ResultGameFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        // Populate @Inject fields in test class
        hiltRule.inject()
    }

    @Test
    fun testDisplayResultWithGivenFizzBuzzObject() {
        //given
        val fizzBuzz  = FizzBuzz(3, 5 , 15, "fizz", "buzz")
       val listResult = listOf("1","2","fizz","4","buzz","fizz","7","8","fizz","buzz","11","fizz","13","14","fizzbuzz")

        //when
        val bundle = bundleOf("fizzBuzz" to fizzBuzz)
        launchFragmentInHiltContainer<ResultGameFragment>(themeResId = R.style.Theme_FizzBuzz, fragmentArgs = bundle)

        //then
        listResult.forEachIndexed { index, value ->
            onView(withId(R.id.result_list))
                .perform(scrollToPosition<RecyclerView.ViewHolder>(index))
                .check(matches(RecyclerViewMatcher.atPosition(index, withText(value))));
        }

    }
}