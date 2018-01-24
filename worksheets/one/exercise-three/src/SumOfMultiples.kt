object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {

        fun findMul(num: Int , ceiling: Int): List<Int> {

            return (1..ceiling)
                    .map { it * num }
                    .filter {it < limit}

        }


        return factors.flatMap { it -> findMul(it, limit/it) }.toSet().sum()
    }

}



