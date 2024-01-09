package ru.als.dataStructures.trees

class TrieNode<Key: Any>(var key: Any?, parent: TrieNode<Key>?) {
    var children: HashMap<Key, TrieNode<Key>> = HashMap()
    var isTerminating: Boolean = false
}