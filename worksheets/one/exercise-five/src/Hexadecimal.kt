object Hexadecimal {

    fun toDecimal(s: String): Int {

        //return Integer.parseInt(s, 16)
        var counter = 0
        var finalResult = 0

        fun validString(ch: Char): Boolean {

            return "abcdef0123456789".contains(ch)
        }

        fun calculator(ch: Char): Int {

            fun converter(): Int {

                return when (ch) {
                    'a' -> 10
                    'b' -> 11
                    'c' -> 12
                    'd' -> 13
                    'e' -> 14
                    'f' -> 15
                    else -> Character.getNumericValue(ch)
                }
            }

            val result = (Math.pow(16.toDouble(),counter.toDouble())
            * converter()).toInt()
            counter++
            return result
        }


        s.toLowerCase().reversed().forEach{
            if(!validString(it))  return 0 ; finalResult += calculator(it)
        }
        return finalResult

    }


}

