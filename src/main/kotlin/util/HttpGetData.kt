package util

import java.net.URL

class HttpGetData(var URL : String = "https://adventofcode.com/2021/day/1/input", var cookie : String = "session=53616c7465645f5fbf560b5ce951ed2eedc79f14d28ed5598fe4d0509e432ddd7c0dd06d434f4a84b1f1aa2d0e9a955d") {
    fun getAdventOfCodeInputData() : String {
        val url = URL(URL)
        val connection = url.openConnection()
        connection.setRequestProperty ("cookie", cookie)

        return connection.inputStream.bufferedReader().readText()
    }
}