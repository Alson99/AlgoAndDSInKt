package ru.als.algo.sorting

import kotlin.math.pow

class Challenge : InsertionSort() {

    // All the instances of a given values in the
    // list to the right side of the array
    fun <T: Comparable<T>> MutableList<T>.rightAlign(element: T) {
        if (this.size < 2) return

        var searchIndex = this.size - 2

        while (searchIndex >= 0) {

            if (this[searchIndex] == element) {
               var moveIndex = searchIndex

               while (moveIndex < this.size - 1 && this[moveIndex + 1] != element) {
                   //swapAt(moveIndex, moveIndex + 1)
                   moveIndex++
               }
            }
            searchIndex--
        }
    }

    // Duplicate finder
    fun <T: Comparable<T>> MutableList<T>.biggestDuplicate(): T? {
        //this.selectionSort()
        for (i in (1 .. this.size).reversed()) {
            if (this[i] == this[i -1]) {
                return this[i]
            }
        }
        return null
    }

    // Manual reverse
    fun <T: Comparable<T>> MutableList<T>.reverse() {
        var left = 0
        var right = this.size - 1

        while (left < right) {
            //swapAt(left, right)
            left++
            right--
        }
    }
}

class Challenge {

    fun Int.digits(): Int {
        var count = 0
        var num = this
        while (num != 0) {
            count +=1
            num /= 10
        }
        return count
    }

    fun Int.digit(atPosition: Int): Int {
        if (atPosition > digits()) return this
        var num = this
        val correctedPosition = (atPosition + 1).toDouble()
        while (num / (10.0.pow(correctedPosition).toInt()) != 0) {
            num /= 10
        }
        return num % 10
    }

    fun MutableList<Int>.lexicographicalSort() {
        this.clear()
        this.addAll(msdRadixSorted(this, 0))
    }

    private fun msdRadixSorted(list: MutableList<Int>, pos: Int) : MutableList<Int> {
        if (pos > list.maxDigits()) return list

        val buckets = arrayListOf<MutableList<Int>>().apply {
            for (i in 0..9) {
                this.add(arrayListOf())
            }
        }

        val priorityBucket = arrayListOf<Int>()

        list.forEach {
            number ->
            val digit = number.digit(pos)
            if (digit == 0) {
                priorityBucket.add(number)
                return@forEach
            }
            buckets[digit].add(number)
        }

        priorityBucket.addAll (
            buckets.reduce { result, bucket ->
                if (bucket.isEmpty()) return@reduce result
                result.addAll(msdRadixSorted(bucket, pos + 1))
                result
            }
        )
        return priorityBucket
    }

    private fun MutableList<Int>.maxDigits(): Int {
        return this.max()?.digits() ?: 0
    }
}