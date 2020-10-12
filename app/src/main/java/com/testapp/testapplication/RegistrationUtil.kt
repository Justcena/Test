package com.testapp.testapplication

object RegistrationUtil {

    private val existingUsers = listOf("Peter", "Carl")

    /**
     * the input is not valid if...
     * ...the username/password is empty or already taken
     * ...the password and confirm password is not the same az the real password
     * ...the password contains less than 2 digits
     */

    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        return true
    }
}