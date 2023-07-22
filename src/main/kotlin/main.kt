import ru.als.complexity.complexity.TimeComplexity
import ru.als.complexity.dataStructures.linkedList.LinkedList
import ru.als.complexity.dataStructures.linkedList.Node

fun main() {
    val timeComplexity = TimeComplexity()
    timeComplexity.chechFirst(listOf(" ", "Als"))
    timeComplexity.printNames(listOf("Alson", "Junior", "Fils"))
    timeComplexity.multiplicationTable(2)

    // Call Node
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)

    node1.next = node2
    node2.next = node3

    println(node1)

    // push method
    val list = LinkedList<Int>()
    list.push(3)
    list.push(2)
    list.push(1)

    println(list)

    // Append method
    list.append(1)
    list.append(2)
    list.append(3)

    println(list)

    println("Before inserting: $list")
    var middleNode = list.nodeAt(1)!!
    for (i in 1..3){
        middleNode = list.insert(-1 * i, middleNode)
    }
    println("After inserting: $list")

    println("Before popping list: $list")
    val poppedValue = list.pop()
    println("After popping list: $list")
    println("Popped value: $poppedValue")

    println("Before removing last node: $list")
    val removeValue1 = list.removeLast()
    println("After removing last node: $list")
    println("Removed value: $removeValue1")

    println("Before removing at particular index: $list")
    val index = 1
    val node = list.nodeAt(index - 1)!!
    val removeValue2 = list.removeAfter(node)

    println("After removing at index $index: $list")
    println("Removed value: $removeValue2")

    for (item in list){
        println("Double: ${item * 2}")
    }

    val list2: MutableCollection<Int> = LinkedList()
    list2.add(3)
    list2.add(2)
    list2.add(1)
    list2.add(4)
    list2.add(5)

    println(list2)
    list2.removeAll(listOf(3, 4, 5))
    println(list2)

    println("Here are challenges")
    val list3 = LinkedList<Int>()
    list3.add(3)
    list3.add(2)
    list3.add(1)
    list3.add(5)

    println(list3)
    list3.printInReverse()

    println()

}