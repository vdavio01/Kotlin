package Worksheet01.Observer

interface Observer {
    fun update(description: String): Unit
    fun subscribe(): Unit
    fun unsubscribe(): Unit
}