package com.testapp.testapplication

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class RegistrationUtilTest {
    @Test
    fun `empty username returns false`() {
        val resutl = RegistrationUtil.validateRegistrationInput("s", "123", "123")
        assertThat(resutl).isFalse()
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("Carl", "123", "123")
        assertThat(result).isFalse()
    }

    @Test
    fun `the password is empty return false`() {
        val result = RegistrationUtil.validateRegistrationInput("ali", "", "")
        assertThat(result).isFalse()
    }
}