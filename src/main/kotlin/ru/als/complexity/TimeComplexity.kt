package ru.als.complexity

class TimeComplexity {

    val numbers = listOf(2, 3, 1, 56, 66, 68, 80, 99, 105, 450)

    // Constant Time, Big 0 is O(1)
    fun chechFirst(names: List<String>) {
        if (names.firstOrNull() != null){
            println(names.first())
        } else {
            println("No names")
        }
    }

    // Linear Time, the Big O is O(n)
    fun printNames(names: List<String>){
        for (name in names){
            println(name)
        }
    }

    // Quadratic Time, the Big O is O(n^2)
    fun multiplicationTable(size: Int){
        for(number in 1..size){
            print(" | ")
            for (otherNumber in 1..size){
                print("$number x $otherNumber = ${number * otherNumber} |")
            }
            println()
        }
    }

    // Simple linear
    fun linearContains(value: Int, numbers: List<Int>): Boolean {
        for (element in numbers){
            if (element == value){
                return true
            }
        }
        return false
    }

    // Logarithmic Time, Big O is O(log n)
    fun pseudoBinaryContains(value: Int, numbers: List<Int>): Boolean {
        if (numbers.isEmpty()) return false

        val middleIndex = numbers.size / 2

        if (value <= numbers[middleIndex]){
            for (index in 0..middleIndex){
                if (numbers[index] == value){
                    return true
                }
            }
        }
        return false
    }

    // Quasilinear time, Big O is O(n log n) and it's the multiplication of
    // linear and logarithmic


    // Comparing time complexity
    fun sumFromOne(n: Int): Int {
        var result = 0
        for (i in 1..n){
            result += 1
        }
        return result
    }



}