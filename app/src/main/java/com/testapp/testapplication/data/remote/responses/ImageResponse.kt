package com.testapp.testapplication.data.remote.responses

data class ImageResponse(
    val hits: List<ImageResult>,
    val total: Int,
    val totalHints: Int
)