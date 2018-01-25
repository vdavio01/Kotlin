class Deque<T> {
    private var head: Element<T>? = null
    private var lastElement: Element<T>? = null

    fun push(value: T) {
        val newElement = Element(value)


        when (lastElement) {
            null -> {
                head  = newElement
                lastElement = newElement
            }
            else -> {

                newElement.prev = lastElement
                lastElement = newElement
            }
        }



    }

    fun pop(): T? {

        val temp = lastElement

        return when(temp) {
            null -> {
                println("Empty list!!")
                null
            }
            else -> {

                lastElement = temp.prev

                if(lastElement != null) {
                    lastElement!!.next = null
                } else { //lastElement == head
                    head = null
                }
                temp.value
            }
        }

    }

    fun unshift(value: T) {
        val newValue = Element(value)
        println("the value of head is : ${head?.value}")
        when(lastElement) {
            null -> {
                head = newValue
                lastElement = newValue
            }
            else -> {

                newValue.next = head

                head!!.prev = newValue

                head = newValue
            }

        }


    }

    fun shift(): T? {
        val value = head?.value
        // TODO
        return value
    }

    private data class Element<T>(val value: T, var prev: Element<T>? = null, var next: Element<T>? = null)
}



