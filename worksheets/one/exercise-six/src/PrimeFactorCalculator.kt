object PrimeFactorCalculator {

    fun primeFactors(int: Int): List<Int> {

        return calculator(int,2)
    }

    fun primeFactors(long: Long): List<Long> {

        return longCalculator(long)
    }


    private fun calculator(number: Int, divisor: Int): List<Int> {
        return when {
            number % divisor == 0 ->  listOf(divisor) + calculator(number/divisor, divisor)

            number > 1 -> calculator(number, divisor + 1)

            else -> listOf()
        }

    }

    private fun longCalculator(number: Long): List<Long> {
        val myList = mutableListOf<Long>()
        var divisor = 2L
        var num = number
        while(num / divisor > 0L) {
            if(num % divisor == 0L) {
                num/= divisor
                myList.add(divisor)
            } else {
                divisor ++
            }
        }

        return myList
    }

}


