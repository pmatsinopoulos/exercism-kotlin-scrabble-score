import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.time.Duration
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@RunWith(Parameterized::class)
class ScrabbleScoreTest(val input: String, val expectedOutput: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: scoreWord({0})={1}")
        fun data() = listOf(
                arrayOf("a", 1),
                arrayOf("A", 1),
                arrayOf("f", 4),
                arrayOf("at", 2),
                arrayOf("zoo", 12),
                arrayOf("street", 6),
                arrayOf("quirky", 22),
                arrayOf("OxyphenButazone", 41),
                arrayOf("pinata", 8),
                arrayOf("", 0),
                arrayOf("abcdefghijklmnopqrstuvwxyz", 87)
        )
    }

    @Test
    fun test() {
        assertEquals(expectedOutput, ScrabbleScore.scoreWord(input))
    }
}

class MyTest {
    private val pool = 'A'..'Z'
    private val length = 1_000
    private val word = (1..length).map { pool.random() }.joinToString("")

    @OptIn(ExperimentalTime::class)
    @Test
    fun `benchmarking scoreWord`() {
        val elapsed: Duration = measureTime {
            ScrabbleScore.scoreWord(word)
        }
        println("Elapsed for scoreWord: $elapsed")
    }

    @OptIn(ExperimentalTime::class)
    @Test
    fun `benchmarking of scoreWord2`() {
        val elapsed: Duration = measureTime {
            ScrabbleScore.scoreWord2(word)
        }
        println("Elapsed for scoreWord2: $elapsed")
    }
}
