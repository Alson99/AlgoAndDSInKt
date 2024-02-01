package ru.als.dataStructures.trees

typealias Visitor1<T> = (T) -> Unit
class BinaryNode<T: Comparable<T>>(var value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null
    val isBinarySearchTree: Boolean
        get() = isBST(this, min = null, max = null)

    private fun isBST(tree: BinaryNode<T>?, min: T?, max: T?): Boolean {
        tree ?: return true
        if (min != null && tree.value <= min) {
            return false
        } else if (max != null && tree.value > max) {
            return false
        }

        return isBST(tree.leftChild, min, tree.value) && isBST(tree.rightChild, tree.value, max)
    }

    override fun equals(other: Any?): Boolean {
        return if (other != null && other is BinaryNode<*>) {
            this.value == other.value &&
                    this.leftChild == other.leftChild &&
                    this.rightChild == other.rightChild
        } else {
            false
        }
    }
    val mininum: BinaryNode<T>?
        get() = leftChild?.mininum ?: this

    // Add diagram
    override fun toString() = diagram(this)

    private fun diagram(
        node: BinaryNode<T>,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                node.rightChild?.let { it1 -> diagram(it1, top, "$top┌──", "$top|") } +
                        root + "${node.value}\n" + node.leftChild?.let { it1 ->
                    diagram(
                        it1,
                        "$bottom|", "$bottom└──", bottom
                    )
                }
            } ?: "${root}null\n"
        }
    }

    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        value
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        value
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        value
    }

    val min: BinaryNode<T>?
        get() = leftChild?.min ?: this
}