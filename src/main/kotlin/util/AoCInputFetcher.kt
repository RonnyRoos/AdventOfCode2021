package util

import java.net.URL

class AoCInputFetcher(private val cookie : String) {
    fun getAdventOfCodeInputData(URL : String) : String {
        val url = URL(URL)
        val connection = url.openConnection()
        connection.setRequestProperty ("cookie", cookie)

        return connection.inputStream.bufferedReader().readText()
    }
}