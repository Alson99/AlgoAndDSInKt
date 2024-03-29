package ru.als.algo.sorting

class RadixSort {
    fun MutableList<Int>.radixSort() {
        val base = 10
        var done = false
        var digits = 1
        while (!done) {
            val buckets = arrayListOf<MutableList<Int>>().apply {
                for (i in 0..9) {
                    this.add(arrayListOf())
                }
            }
            this.forEach {
                number ->
                val remainingPart = number / digits
                val digit = remainingPart % base
                buckets[digit].add(number)
                if (remainingPart > 0 ) {
                    done = false
                }
            }
            digits *= base
            this.clear()
            this.addAll(buckets.flatten())
        }
    }
}