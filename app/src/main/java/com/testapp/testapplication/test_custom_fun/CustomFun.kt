package com.testapp.testapplication.test_custom_fun

object CustomFun {
    fun fibonacci(n: Int): Long {
        if (n == 0 || n == 1) {
            return n.toLong()
        }

        var a = 0L
        var b = 1L
        var c = 1L
        (1..n - 2).forEach { _ ->
            c = a + b
            a = b
            b = c
        }
        return c
    }


    fun checkBraces(string: String): Boolean {
        return string.count { it == '(' } == string.count { it == ')' }
    }

}