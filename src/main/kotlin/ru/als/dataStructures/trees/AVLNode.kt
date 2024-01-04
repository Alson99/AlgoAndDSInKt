package ru.als.dataStructures.trees

import kotlin.math.max
import kotlin.math.pow

class AVLNode<T: Comparable<T>>(var value: T) {
    private var height = 0
    private var leftChild: AVLNode<T>? = null
    private var rightChild: AVLNode<T>? = null
    private val leftHeight: Int
        get() = leftChild?.height ?: -1
    private val rightHeight: Int
        get() = rightChild?.height ?: -1
    private val balanceFactor: Int
        get() = leftHeight - rightHeight

    private fun leftRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.rightChild!!
        node.rightChild = pivot.leftChild
        pivot.leftChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return node
    }

    private fun rightRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }

    private fun rightLeftRotate(node: AVLNode<T>): AVLNode<T> {
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }

    private fun leftRightRotate(node: AVLNode<T>) : AVLNode<T> {
        val leftChild = node.leftChild ?: return node
        node.leftChild = leftRotate(leftChild)
        return rightRotate(node)
    }

    private fun balanced(node: AVLNode<T>): AVLNode<T> {
        return when (node.balanceFactor) {
            2 -> {
                if (node.leftChild?.balanceFactor == -1) {
                    leftRightRotate(node)
                } else {
                    rightRotate(node)
                }
            }
            -2 -> {
                if (node.rightChild?.balanceFactor ==  1) {
                    rightLeftRotate(node)
                } else {
                    leftRotate(node)
                }
            }
            else -> node
        }
    }

    fun insert(node: AVLNode<T>, value: T) : AVLNode<T> {
        node ?: return AVLNode(value)
        if (value < node.value) {
            node.leftChild = node.leftChild?.let { insert(it, value) }
        } else {
            node.rightChild = node.rightChild?.let { insert(it, value) }
        }
        val balanceNode = balanced(node)
        balanceNode.height = max(
            balanceNode.leftHeight ?: 0,
            balanceNode.rightHeight ?: 0) + 1
        return balanceNode
    }

    fun remove(node: AVLNode<T>, value: T) : AVLNode<T> {
        node.value
        if (value < node.value) {
            node.leftChild = node.leftChild?.let { insert(it, value) }
        } else {
            node.rightChild = node.rightChild?.let { insert(it, value) }
        }
        val balanceNode = balanced(node)
        balanceNode.height = max(
            balanceNode.leftHeight,
            balanceNode.rightHeight) + 1
        return balanceNode
    }
    fun leafNodes(height: Int) : Int {
        return 2.0.pow(height).toInt()
    }
    fun nodes(height: Int) : Int {
        return 2.0.pow(height + 1).toInt() - 1
    }
}