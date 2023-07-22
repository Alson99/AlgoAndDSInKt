package ru.als.complexity.complexity

class SpaceComplexity {

    fun printSorted(numbers: List<Int>){
        val sorted = numbers.sorted()
        for (element in sorted){
            println(element)
        }
    }

}