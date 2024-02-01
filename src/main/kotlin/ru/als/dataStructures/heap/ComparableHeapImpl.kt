package ru.als.dataStructures.heap

import kotlin.coroutines.CoroutineContext

class ComparableHeapImpl<Element : Comparable<Element>>(override val count: Int) : AbstractHeap<Element>() {
    override fun compare(a: Element, b: Element): Int {
        return a.compareTo(b)
    }
    override fun insert(element: Element) {
        TODO("Not yet implemented")
    }

    override fun peek(): Element? {
        TODO("Not yet implemented")
    }

    override fun remove(): Element? {
        TODO("Not yet implemented")
    }

    override fun remove(index: Int): Element? {
        TODO("Not yet implemented")
    }

  /*  companion object {
        fun <Element: Comparable<Element>> create(
            element: ArrayList<Element>
        ) : Heap<Element> {
            val heap = ComparableHeapImpl<Element>()
            heap.heapify(element)
            return heap
        }
    }*/
}