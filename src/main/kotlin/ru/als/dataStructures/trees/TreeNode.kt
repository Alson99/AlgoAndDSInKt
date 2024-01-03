package ru.als.dataStructures.trees

import com.sun.jmx.remote.internal.ArrayQueue
import ru.als.dataStructures.queue.ArrayListQueue
import ru.als.dataStructures.queue.Queue

class TreeNode<T>(val value: T) {

    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach{ queue.enqueue(it)}
        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }
    fun search(value: T) : TreeNode<T>? {
        var result: TreeNode<T>? = null

        forEachLevelOrder {
            if (it.value == value) {
                result = it
            }
        }
        return result
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit