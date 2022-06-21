package com.compose.navigation.core.util.model

data class AppDetailsResponse<out T>(
    override val status: String = "",
    val data: T
) : AppResponse()
