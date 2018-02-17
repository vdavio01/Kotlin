@file:Suppress("UNCHECKED_CAST")

fun <T> tail(l: List<T>): List<T> {
    return when(l.size) {
        0 -> throw IllegalArgumentException("Empty List")
        else -> l.drop(1)
    }

}

fun <T> setHead(l: List<T>, item: T): List<T> {
    return when(l) {
        emptyList<T>() -> listOf(item)
        else -> listOf(item) + tail(l)
    }
}

fun <T> drop(l: List<T>, n: Int): List<T> {
    return when {
        n > l.size -> emptyList()
        n == 0 -> l
        else -> drop(tail(l), n - 1)

    }

}

fun <T> init(l: List<T>): List<T> {
    return when (l.size) {

        0 -> throw IllegalArgumentException("Empty List")
        else -> {
            //1st solution
            l.dropLast(1)

            //2nd (odd) solution
            //l.reversed().drop(1).reversed()

            //3rd (odd) solution using drop(l: List<T>, n: Int)
            //drop(l.reversed(),1).reversed()

            //4th (odd) solution using tail(l:List<T>)
            //tail(l.reversed()).reversed()
        }
    }
}

fun <T> foldLeft(l: List<T>, initial : T, f: (T, T) -> T): T {


    return when(l.size) {
        0 -> initial
        else -> f(l[0], foldLeft(tail(l),initial,f))
    }

}

fun <T> sum(l: List<T>) : T {

    return when {

    //Helper functions at the bottom of the sheet
        l.listOfDoubles() -> foldLeft(listOfDoubles(l), 0.0 , {x,y -> x + y}) as T


        l.listOfFloat() -> foldLeft(floatList(l), 0f, {x,y -> x + y}) as T


        l.listOfInts() -> foldLeft(listOfInts(l), 0, {x,y -> x + y}) as T


        l.listOfLong() -> foldLeft(longList(l), 0L, {x,y -> x + y}) as T


        else -> throw IllegalArgumentException("Invalid List")

    }

}


fun <T> product(l: List<T>) : T {
    return when {

    //Helper functions at the bottom of the sheet
        l.listOfDoubles() -> foldLeft(listOfDoubles(l), 1.0 , {x,y -> x * y}) as T


        l.listOfFloat() -> foldLeft(floatList(l), 1f, {x,y -> x * y}) as T


        l.listOfInts() -> foldLeft(listOfInts(l), 1, {x,y -> x * y}) as T


        l.listOfLong() -> foldLeft(longList(l), 1L, {x,y -> x * y}) as T


        else -> throw IllegalArgumentException("Invalid List")

    }
}

fun <T> length(l: List<T>) : Int {
    return when {
        l.isEmpty() -> 0
        else ->{
            1  + length(drop(l,1))
        }
    }
}



fun <T> reverse(l: List<T>): List<T> {
    return when(length(l)) {
        0 -> l
        else -> reverse(tail(l)) + listOf(foldLeft(l, 0,{ x, _ -> x})) as List<T>

    }
}

fun <T> flatten(l: List<List<T>>): List<T> {

    return  when{

        length(l) == 0 -> emptyList()
        else -> foldLeft(l, emptyList(), { x, _ -> x})  + flatten(tail(l))
    }

}

fun <T> map(l: List<T>, f: (T) -> T): List<T> {

    return when{
        l.isEmpty() -> emptyList()
        else -> listOf(f(foldLeft(l,0,{ x, _ -> x}) as T)) + map(tail(l),f)
    }
}



fun <T> filter(l: List<T>, f: (T) -> Boolean): List<T> {
    return when {

        l.isEmpty() -> emptyList()
        else -> {
            val valueToCheck = foldLeft(l,0,{x,_ -> x}) as T //returns the first value of our list
            if(f(valueToCheck) == true) listOf(valueToCheck)  else
            {
                emptyList()
            } + filter(tail(l),f)
        }

    }
}

fun <T> flatMap(l: List<T>, f:(T) -> List<T>): List<T> {

    return when {
        l.isEmpty() -> emptyList()
        else -> f(foldLeft(l,0, {x,_ -> x}) as T) + (flatMap(tail(l), f))
    }

}

fun <T> maxAverage(l: List<Triple<T, T, T>>): T {

    val myListOfTriples =
            // returns a list with only one triple with the max values
            flatMap(l, {it ->  listOf(foldLeft(it.toList() as List<Double>, 0.0,
                    {x,y -> if(x > y) x else y }) ) as List<Triple<T, T, T>>})



    val length = length(myListOfTriples)
    val sumOfList = sum(myListOfTriples) as Double

    val result = sumOfList / length

    return result as T

}

fun <T> variance(l: List<T>): T {

    val sumOfOriginalList = sum(l) as Double
    val lengthOfList = length(l)
    val listAvg = sumOfOriginalList  / lengthOfList
    val mappedList = map(l, {Math.pow(it as Double - listAvg, 2.0) as T})
    val sumOfMappedList = sum(mappedList) as Double
    val variance = sumOfMappedList / lengthOfList

    return variance as T
}


/**
 * Helper functions
 */

fun<T> List<T>.listOfDoubles(): Boolean = this.all { it is Double }

fun<T> List<T>.listOfFloat(): Boolean = this.all { it is Float }

fun<T> List<T>.listOfInts(): Boolean = this.all { it is Int }

fun<T> List<T>.listOfLong(): Boolean = this.all { it is Long }


fun <T>listOfDoubles(myList: List<T>):List<Double> {

    return myList.map { it as Double }

}

fun <T>listOfInts(myList: List<T>):List<Int> {

    return myList.map { it as Int }

}

fun <T>floatList(myList: List<T>):List<Float> {

    return myList.map { it as Float }

}

fun <T>longList(myList: List<T>): List<Long> {

    return myList.map { it as Long }

}