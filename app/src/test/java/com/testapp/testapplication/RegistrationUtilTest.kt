package com.testapp.testapplication

import com.google.common.truth.Truth.assertThat
import com.testapp.testapplication.test_custom_fun.RegistrationUtil
import org.junit.Test


class RegistrationUtilTest {
    @Test
    fun `empty username`() {
        val resutl = RegistrationUtil.validateRegistrationInput("", "123", "123")
        assertThat(resutl).isFalse()
    }
    @Test
    fun `empty password`() {
        val result = RegistrationUtil.validateRegistrationInput("ali", "", "")
        assertThat(result).isFalse()
    }

    @Test
    fun `username already exists`() {
        val result = RegistrationUtil.validateRegistrationInput("", "123", "123")
        assertThat(result).isFalse()
    }


}