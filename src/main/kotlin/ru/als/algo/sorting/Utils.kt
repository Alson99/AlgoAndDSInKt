package ru.als.algo.sorting

open class Utils {
    fun <T> ArrayList<T>.swapAt(first: Int, second: Int) {
        val aux = this[first]
        this[first] = this[second]
        this[second] = aux
    }
}