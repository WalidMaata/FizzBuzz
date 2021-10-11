package com.fizzbuzz.app.statistics

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.fizzbuzz.app.R
import com.fizzbuzz.app.data.repositories.FizzBuzzRepository
import com.fizzbuzz.app.presentation.statistics.StatisticsFragment
import com.fizzbuzz.app.utils.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.*
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class StatisticsFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: FizzBuzzRepository

    @Before
    fun init() {
        // Populate @Inject fields in test class
        hiltRule.inject()
    }

    @Test
    fun testLaunchFragment() {
        launchFragmentInHiltContainer<StatisticsFragment>(themeResId = R.style.Theme_FizzBuzz)
    }
}