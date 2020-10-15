package com.testapp.testapplication

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import com.testapp.testapplication.other.ResourceCompare
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceCompareTest {

    /**
     * this not good for using      private val resourceCompare = ResourceCompare()
    for initializing objects
     */
    private lateinit var resourceCompare: ResourceCompare


    /**
     * this for before every test case running
     */
    @Before
    fun setup() {
        resourceCompare = ResourceCompare()
    }

    @Test
    fun stringResourceSameAsGivingSting_returnTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceCompare.isEqual(context, R.string.app_name, "Test Application")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceSameAsGivingSting_returnFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceCompare.isEqual(context, R.string.app_name, "Difrent name")
        assertThat(result).isFalse()
    }

    @After
    fun tearDown() {
        /**
         * for demonstrait evry object like roomDb,,,,
         */
    }
}