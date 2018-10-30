package Worksheet01.Observer

data class CommentaryObject(var subscribers: List<Observer>, val title: String) : Subject {

    private var details =""

    override fun subscribeObserver(observer: Observer) {

        subscribers += listOf(observer)

    }
    override fun unSubscribeObserver(observer: Observer) {
        println("Removed observer(${subscribers.indexOf(observer) + 1}) from the registered list")
        subscribers = subscribers.filter{it != observer }
    }
    override fun notifyObservers() {

        subscribers.forEach { it.update("Observer(${subscribers.indexOf(it)+1}) : $details") }

    }
    override fun subjectDetails(): String {
        return title
    }

    fun matchDetails(changes: String) {
        details = changes
        notifyObservers()
    }


}




