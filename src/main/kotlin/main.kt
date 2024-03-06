import ru.als.complexity.TimeComplexity
import ru.als.dataStructures.graph.EdgeType
import ru.als.dataStructures.linkedList.LinkedList
import ru.als.dataStructures.linkedList.Node
import ru.als.dataStructures.queue.ArrayListQueue
import ru.als.dataStructures.stack.StackImpl
import ru.als.dataStructures.trees.BinaryNode
import ru.als.dataStructures.trees.BinarySearchTree
import ru.als.dataStructures.trees.TreeNode
import sun.security.provider.certpath.AdjacencyList

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

    // Using stack right here
    val stack1 = StackImpl<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
    }
    print(stack1)

    val poppedElement = stack1.pop()
    if (poppedElement != null){
        println("Popped: $poppedElement")
    }
    print(stack1)

    val list1 = listOf("A", "B", "C", "D")
    val stack = StackImpl.create(list1)
    print(stack)
    println("Popped: ${stack.pop()}")

    // Using Queue right here

    val queue = ArrayListQueue<String>().apply {
        enqueue("Fils")
        enqueue("Alson")
        enqueue("Brunel")
    }

    println(queue)
    queue.dequeue()
    println("Next up: ${queue.peek()}")


    // Using trees
    val tree = makeBeverageTree()
    tree.forEachDepthFirst { println(it.value) }
    tree.forEachLevelOrder { println(it.value) }
    tree.search("ginger ale")?.let {
        println("Found node: ${it.value}")
    }
    tree.search("WKD Blue")?.let {
        println(it.value)
    } ?: println("Couldn't find WKD Blue")


    // Implementation of BinaryTree
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)

    seven.leftChild = one
    one.rightChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight

    val tree1 = seven


    // BinarySearchTree
    val bst = BinarySearchTree<Int>()
    (0..4).forEach {
        bst.insert(it)
    }
    println(bst)

    val exampleTree = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }
    println(exampleTree)

    if (exampleTree.contains(5)) {
        println("Found 5!")
    } else {
        println("Couldn't find 5")
    }
    println("Tree before removal:")
    println(exampleTree)
    exampleTree.remove(3)
    println("Tree after removing root:")
    println(exampleTree)


    // AVLTrees
  /*  val tree2 = AVLNode<Int>()
    tree2.insert(15)
    tree2.insert(10)
    tree2.insert(16)
    tree2.insert(18)
    println(tree2)*/

    // Let's implement Binary search
    val array = arrayListOf(1,2,3,4,4,5)
    val secondIndex = array.indexOf(2)
    println(secondIndex)
    val secondIndexBinary = array.binarySearch(secondIndex)
    println(secondIndexBinary)

    // Graph
    val graph = ru.als.dataStructures.graph.AdjacencyList<String>()
    val singapore = graph.createVertex("Singapore")
    val tokyo = graph.createVertex("Tokyo")
    val hongKong = graph.createVertex("Hong Kong")
    val detroit = graph.createVertex("Detroit")
    val sanFrancisco = graph.createVertex("San Francisco")
    val washingtonDC = graph.createVertex("Washington DC")
    val austinTexas = graph.createVertex("Austin Texas")
    val seattle = graph.createVertex("Seattle")

    graph.add(EdgeType.UNDIRECTED, singapore, hongKong, 300.0)
    graph.add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, washingtonDC, 300.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, sanFrancisco, 600.0)
    graph.add(EdgeType.UNDIRECTED, detroit, austinTexas, 50.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, washingtonDC, 292.0)
    graph.add(EdgeType.UNDIRECTED, sanFrancisco, washingtonDC,
        337.0)
    graph.add(EdgeType.UNDIRECTED, washingtonDC, seattle, 277.0)
    graph.add(EdgeType.UNDIRECTED, sanFrancisco, seattle, 218.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, sanFrancisco, 297.0)
    println(graph)
}

fun makeBeverageTree(): TreeNode<String> {

    val tree = TreeNode("Beverages")
    val hot = TreeNode("hot")
    val cold = TreeNode("cold")
    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")
    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")

    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)

    cold.add(milk)
    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)
    soda.add(gingerAle)
    soda.add(bitterLemon)
    return tree

    // Here using Binary search

}