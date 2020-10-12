package com.testapp.testapplication

import android.content.Context

class ResourceCompare {
    fun isEqual(context: Context, resId: Int, string: String): Boolean {
        return context.getString(resId) == string

    }
}