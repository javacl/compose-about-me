package compose.about.me.core.util.api

object ApiUrlHelper {

    init {
        update()
    }

    lateinit var API_URL: String

    lateinit var GET_ARTICLE_LIST_API_URL: String

    private fun update() {
        API_URL = "https://newsapi.org/v2/"
        GET_ARTICLE_LIST_API_URL = "${API_URL}everything"
    }
}
