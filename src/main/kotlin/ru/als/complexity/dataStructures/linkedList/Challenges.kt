package ru.als.complexity.dataStructures.linkedList

class Challenges {

    // Reverse a linked list
    private fun<T : Any> LinkedList<T>.printInReverse() {
        this.nodeAt(0)?.printInReverse()
    }

    private fun <T : Any> Node<T>.printInReverse() {
        this.next?.printInReverse()

        // 1
        if (this.next != null){
            print(" <- ")
        }
        // 2
        print(this.value.toString())
    }

    fun <T : Any> LinkedList<T>.getMiddle(): Node<T>? {
        var slow = this.nodeAt(0)
        var fast = this.nodeAt(0)

        while (true) {
            if (fast != null) {
                fast = fast.next
            }

            if (fast != null) {
                fast = fast.next
                slow = slow?.next
            }

        }
        return slow
    }

}