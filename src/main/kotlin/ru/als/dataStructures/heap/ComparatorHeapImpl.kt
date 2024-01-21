package ru.als.dataStructures.heap

class ComparatorHeapImpl<Element>(
    private val comparator: Comparator<Element>, override val count: Int
) : AbstractHeap<Element>() {
    override fun compare(a: Element, b: Element): Int {
        return comparator.compare(a,b)
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
        fun <Element> create (
            elements: ArrayList<Element>,
            comparator: Comparator<Element>
        ) : Heap<Element> {
            val heap = ComparatorHeapImpl(comparator)
            heap.heapify(elements)
            return heap
        }
    }*/
}