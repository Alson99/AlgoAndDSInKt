package ru.als.algo.sorting

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