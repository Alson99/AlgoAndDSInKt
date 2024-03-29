package ru.als.dataStructures.stack

interface Stack<T : Any> {
    fun push(element: T)
    fun pop(): T?

    fun peek(): T?

    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0

    fun<T : Any> stackOf(vararg elements: T) : Stack<T> {
        return StackImpl.create(elements.asList())
    }

}