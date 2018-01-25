object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {

        require(rows>=0) {"Rows can't be negative!"}
        val listArray = List(rows + 1, { i -> IntArray(i, { 1 }) })


        (3..rows).forEach { i ->
            listArray[i].forEachIndexed { index, _ ->
                if(index != 0 && index != listArray[i].lastIndex) {
                    listArray[i][index] = listArray[i - 1][index - 1] + listArray[i - 1][index]
                }
            }
        }
        return listArray.map { it.toList() }.drop(1)
    }
}


