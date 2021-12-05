import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import solution.Solution
import solution.Solution01
import util.AoCInputFetcher

class SelectSolution : CliktCommand() {
    private val classConstructors = listOf<() -> Solution>(
        ::Solution01,
    )

    private val aocCookie by option(envvar = "AOC_COOKIE")
    private val solutionNumber by option().prompt()

    override fun run() {
        val solutionNumber : Int = solutionNumber.toInt()
        val cookie : String
        if(aocCookie.isNullOrEmpty()) {
            error("No cookies, come to the dark side")
        } else {
            cookie = aocCookie.toString()
        }

        val aoCInputFetcher = AoCInputFetcher(cookie)
        val solution : Solution = classConstructors[solutionNumber - 1]()

        println(solution.getSolution(aoCInputFetcher))
    }
}

fun main(args: Array<String>) = SelectSolution().main(args)
