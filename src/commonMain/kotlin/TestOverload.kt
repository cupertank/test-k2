import kotlin.jvm.JvmName

@JvmName("arrayVararg")
fun array(vararg elements: Int): Array<Int> = elements.toTypedArray()

fun array(elements: IntArray): Array<Int> = elements.toTypedArray()

fun main() {
    /*
    Fails in K2 with:

    Overload resolution ambiguity between candidates:
    @JvmName(...) fun array(vararg elements: Int): Array<Int>
    fun array(elements: IntArray): Array<Int>
     */
    val workInKotlin19ButNotInK2 = array(elements = intArrayOf(1, 2, 3))

    val workInBoth = array(intArrayOf(1, 2, 3))
}
