package Worksheet01.Observer

import java.util.*


class SMSUsersObserver(val observable: Observable, var description: String, private var subject: Subject) : Observer {




    override fun update(description: String) {

        smsUsers(description)

    }

    override fun subscribe() {

        subject.subscribeObserver(this)
    }

    override fun unsubscribe() {

        subject.unSubscribeObserver(this)

    }


    private fun smsUsers(description: String) {
        println(description)
    }


}