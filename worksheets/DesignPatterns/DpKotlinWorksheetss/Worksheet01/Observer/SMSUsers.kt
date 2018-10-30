package Worksheet01.Observer

class SMSUsers(val s: Subject, val msg: String) : Observer {


    override fun update(description: String) {

        printOutMatchDetails(description)
    }

    override fun subscribe() {
        s.subscribeObserver(this)
    }

    override fun unsubscribe() {
        s.unSubscribeObserver(this)
    }


    private fun printOutMatchDetails(details: String) {
        println(details)
    }

}
