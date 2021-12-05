package solution

import util.AoCInputFetcher

class Solution02 : Solution {
    override fun getSolution(aoCInputFetcher : AoCInputFetcher): String {

        val depthList = aoCInputFetcher
            .getAdventOfCodeInputData("https://adventofcode.com/2021/day/1/input")
            .removeSuffix("\n").split("\n")
            .map { it.toInt() }


        var previous = Int.MIN_VALUE
        var counter = -1
        depthList.forEach {
            if (it > previous) {
                println("$it (increased)")
                counter++
            } else {
                println("$it (decreased)")
            }
            previous = it
        }

        println(counter)

        return counter.toString()
    }
}