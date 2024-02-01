package ru.als.dataStructures.heap

interface Heap<Element> : Collection<Element> {
    fun peek() : Element ?
}