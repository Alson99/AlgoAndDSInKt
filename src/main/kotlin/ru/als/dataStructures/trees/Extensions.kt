package ru.als.dataStructures.trees

import java.security.Key

class Extensions {
    fun Trie<Char>.remove(string: String) {
        remove(string.toList())
    }

    fun Trie<Char>.contains(string: String) : Boolean {
        return contains(string.toList())
    }

    fun Trie<Char>.collections(prefix: List<Key>) : List<String> {
        return collections(prefix.toList())
    }
}