package ru.als.dataStructures.trees

class Trie<Key: Any> {
    private val root = TrieNode<Key>(key = null, parent = null)
    fun insert(list: List<Key>) {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: TrieNode(element, current)
            current.children[element] = child
            current = child
        }
        current.isTerminating = true
    }

    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }
        return  current.isTerminating
    }

    fun remove(list: List<Key>) {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return
            current = child
        }
        if (!current.isTerminating) return
        current.isTerminating = false

        val parent = current
        while(current.children.isEmpty() && !current.isTerminating) {
            parent.children.remove(current.key)
            current = parent
        }

    }
    fun collections(prefix: List<Key>, node: TrieNode<Key>) : List<List<Key>> {
        val results = mutableListOf<List<Key>>()
        if (node.isTerminating) {
           results.add(prefix)
        }
        node.children.forEach { (key, node) ->
            results.addAll(collections(prefix + key, node))
        }
        return results
    }

}

