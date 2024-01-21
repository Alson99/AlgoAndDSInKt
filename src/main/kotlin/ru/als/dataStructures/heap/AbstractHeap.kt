package ru.als.dataStructures.heap

import java.util.Collections

abstract class AbstractHeap<Element> : Heap<Element> {

    var elements : ArrayList<Element> = ArrayList<Element>()

    override val count: Int
        get() = elements.size

    override fun peek(): Element? {
        return elements.first()
    }

    private fun leftChildIndex(index: Int) = (2 * index) + 1

    private fun rightChildIndex(index: Int) = (2 * index) + 2

    private fun parentIndex(index: Int) = (index - 1) / 2
    abstract fun compare(a: Element, b: Element) : Int

    override fun insert(element: Element) {
        elements.add(element) // 1
        siftUp(count - 1) // 2
    }

    private fun siftUp(index: Int) {
        var child = index
        var parent = parentIndex(child)
        while (child > 0 && compare(elements[child], elements[parent]) > 0) {
            Collections.swap(elements, child, parent)
            child = parent
            parent = parentIndex(child)
        }
    }

    override fun remove(): Element? {
        if (isEmpty) return null // 1
        Collections.swap(elements, 0, count - 1) // 2
        var item = elements.removeAt(count - 1) // 3
        siftDown(0) // 4
        return item
    }

    private fun siftDown(index: Int) {
        var parent = index
        while (true) {
            val left = leftChildIndex(parent)
            val right = rightChildIndex(parent)
            var condidate = parent
            if (left < count && compare(elements[left], elements[condidate]) > 0) {
                condidate = left
            }
            if (right < count && compare(elements[right], elements[condidate]) > 0) {
                condidate = right
            }
            if (condidate == parent) {
                return
            }
            Collections.swap(elements, condidate, parent)
            parent = condidate
        }
    }

    override fun remove(index: Int): Element? {
        if (index >= count) return null
        return if (index == count - 1) {
            elements.removeAt(count - 1)
        } else {
            Collections.swap(elements, index, count - 1)
            val item = elements.removeAt(count - 1)
            siftDown(index)
            siftUp(index)
            item
        }
    }

    private fun index(element: Element, i: Int) : Int? {
        if (i >= count) return null

        //if (sort(element, elements[i])) return null
        if (element == elements[i]) return i

        val lelfChildIndex = index(element, leftChildIndex(i))
        if (lelfChildIndex != null) return lelfChildIndex

        val rightChildIndex = index(element, rightChildIndex(i))
        if (rightChildIndex != null) return rightChildIndex

        return null
    }

    protected fun heapify(values: ArrayList<Element>) {
        elements = values
        if (elements.isNotEmpty()) {
            (count / 2 downTo 0).forEach {
                siftDown(it)
            }
        }
    }
}