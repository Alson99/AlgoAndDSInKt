package ru.als.dataStructures.trees

typealias Visitor1<T> = (T) -> Unit
class BinaryNode<T>(var value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null


    // Add diagram
    override fun toString() = diagram(this)

    private fun diagram(
        node: BinaryNode<T>,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                node.rightChild?.let { it1 -> diagram(it1, "$top", "$top┌──", "$top|") } +
                        root + "${node.value}\n" + node.leftChild?.let { it1 ->
                    diagram(
                        it1,
                        "$bottom|", "$bottom└──", "$bottom")
                }
            }
        } ?: "${root}null\n"
    }

    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        //visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        //visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        //visit(value)
    }

    val min: BinaryNode<T>?
        get() = leftChild?.min ?: this
}