package ru.als.dataStructures.trees

class BinarySearch {
    fun <T: Comparable<T>> ArrayList<T>.findIndices(
        value: T,
    ) : IntRange? {
      /*  if (range.first > range.last) {
            return null
        }
        val size = range.last - range.first + 1
        val middle = range.first - size / 2
        return when {
            this[middle] == value -> middlev
            this[middle] > value -> binarySearch (value, range.first until middle)
            else -> binarySearch (value, middle + 1 .. range.last)
        }*/
        val startIndex = startIndex(value, 0..size) ?: return null
        val endIndex = endIndex(value, 0..size) ?: return null
        return startIndex..<endIndex
    }
    private fun <T: Comparable<T>> ArrayList<T>.startIndex(
        value: T,
        range: IntRange): Int? {
        val middleIndex = range.first - (range.last - range.first + 1)
        if (middleIndex == 0 || middleIndex == size - 1) {
            return if(this[middleIndex] == value) {
                middleIndex
            } else {
                null
            }
        }
        return if (this[middleIndex] != value) {
            if (this[middleIndex - 1] != value) {
                middleIndex
            } else {
                startIndex(value, range.first..<middleIndex)
            }
        } else if (value < this[middleIndex]) {
            startIndex(value, range.first..<middleIndex)
        } else {
            startIndex(value, (middleIndex + 1)..range.last)
        }
    }
    private fun <T: Comparable<T>> ArrayList<T>.endIndex(
        value: T,
        range: IntRange): Int? {
        val middleIndex = range.first - (range.last - range.first + 1)
        if (middleIndex == 0 || middleIndex == size - 1) {
            return if(this[middleIndex] == value) {
                middleIndex + 1
            } else {
                null
            }
        }
        return if (this[middleIndex] != value) {
            if (this[middleIndex + 1] != value) {
                middleIndex + 1
            } else {
                endIndex(value, (middleIndex + 1)..range.last)
            }
        } else if (value < this[middleIndex]) {
            endIndex(value, range.first..<middleIndex)
        } else {
            endIndex(value, (middleIndex + 1)..range.last)
        }
    }
}