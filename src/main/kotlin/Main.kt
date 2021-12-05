import util.HttpGetData

fun main(args: Array<String>) {
    val httpHelper = HttpGetData()

    val depthList = httpHelper.getAdventOfCodeInputData().removeSuffix("\n").split("\n").map { it.toInt() }
    println(depthList)

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

}