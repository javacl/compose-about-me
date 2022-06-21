package com.compose.navigation.core.util.api

import javax.inject.Inject

@Suppress("PrivatePropertyName", "PropertyName")
class ApiUrlHelper @Inject constructor() {

    init {
        update()
    }

    private lateinit var API_URL: String

    lateinit var GET_ARTICLE_LIST_API_URL: String

    private fun update() {
        API_URL = "https://newsapi.org/v2/"
        GET_ARTICLE_LIST_API_URL = "${API_URL}everything"
    }
}
