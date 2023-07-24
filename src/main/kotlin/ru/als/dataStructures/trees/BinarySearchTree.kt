package ru.als.dataStructures.trees

class BinarySearchTree<T : Comparable<T>> {

    var root: BinaryNode<T>? = null
    override fun toString() = root?.toString() ?: "empty tree"

    fun insert(value: T) {
        root = insert(root, value)
    }
    private fun insert(
        node: BinaryNode<T>?,
        value: T
    ) : BinaryNode<T> {
        node ?: return BinaryNode(value)

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        return node
    }

    fun remove(value: T) {
        //root = remove(root, value)
    }

    private fun remove(node: BinaryNode<T>, value: T) : BinaryNode<T>? {
        node ?: return null
        when {
            value ==  node.value -> {
                if (node.leftChild == null && node.rightChild == null) {
                    return null
                }
                if (node.leftChild == null){
                    return node.rightChild
                }
                if (node.rightChild == null) {
                    return node.leftChild
                }

                node.rightChild?.min?.value.let {
                    if (it != null) {
                        node.value = it
                    }
                }
                node.rightChild = remove(node.rightChild!!, node.value)
            }
            value < node.value -> node.leftChild =
                node.leftChild?.let { remove(it, value) }
            else -> node.rightChild = node.rightChild?.let { remove(it, value) }
        }
        return node
    }
}