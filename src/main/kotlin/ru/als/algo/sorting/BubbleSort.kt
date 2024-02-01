package ru.als.algo.sorting
import ru.als.algo.sorting.Utils
class BubbleSort : Utils() {

    fun <T: Comparable<T>> ArrayList<T>.bubbleSort(showPasses: Boolean = false) {

        if (this.size < 2) return

        for (end in (1..<this.size).reversed()) {
            var swapped = false

            for (current in 0..end) {
                if (this[current] > this[current + 1]) {
                    this.swapAt(current, current + 1)
                    swapped = true
                }
            }

            if (showPasses) println(this)
            if (!swapped) return
        }
    }
}