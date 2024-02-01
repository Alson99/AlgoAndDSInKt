package ru.als.algo.sorting

class QuicksortNaive {

    fun<T: Comparable<T>> List<T>.quicksortNaive(): List<T> {
        if (this.size < 2) return this
        val pivot = this[this.size / 2]
        val less = this.filter { it < pivot }
        val equal = this.filter { it == pivot }
        val greater = this.filter { it > pivot }
        return less.quicksortNaive() + equal + greater.quicksortNaive()
    }

    fun <T: Comparable<T>> MutableList<T>.partitionLomuto(
        low: Int,
        high: Int
    ) : Int {
        val pivot = this[high]
        var i = low

        for (j in low .. high) {
            if (this[j] <= pivot) {
                //this.swapAt(i, j)
                i += 1
            }
        }
        //this.swapAt(i, high)
        return i
    }

    fun<T: Comparable<T>> MutableList<T>.quicksortLomuto(
        low: Int,
        high: Int
    ) {
        if (low < high) {
            val pivot = this.partitionLomuto(low, high)
            this.quicksortLomuto(low, pivot - 1)
            this.quicksortLomuto(pivot + 1, high)
        }
    }

    fun<T: Comparable<T>> MutableList<T>.partitionHoare(
        low: Int,
        high: Int
    ) : Int {
        val pivot = this[low]
        var i = low - 1
        var j = high + 1
        while (true) {
            do {
                j -= 1
            } while (this[i] < pivot)
            if (i < j) {
                //this.swapAt(i, j)
            } else {
                return j
            }
        }
    }
}