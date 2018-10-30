package Worksheet01.Observer

import java.util.*

fun main(args: Array<String>) {

    // Using CommentaryObjectObservable and SMSUsersObserver
    val obj: Observable = CommentaryObjectObservable("Soccer Match [2018AUG24]")
    val commentaryObject1 = CommentaryObject(ArrayList(), "Commentary Object 1" )
    val observer = SMSUsersObserver(obj, "Adam Warner [New York]",commentaryObject1)
    val observer2 = SMSUsersObserver(obj, "Tim Ronney [London]",commentaryObject1)

    observer.subscribe()
    observer2.subscribe()
    println("-".repeat(40))
    commentaryObject1.matchDetails("Starting ${(obj as Commentary).description}")
    println("-".repeat(40))
    commentaryObject1.matchDetails("Goal at 5' the score is now 1-0")
    println("-".repeat(40))
    commentaryObject1.matchDetails("That's the end of the match")
    println("-".repeat(40))
    observer.unsubscribe()
    observer2.subscribe()
    println()
    println("#".repeat(40))

    //Using only commentary object and SMSUsers
    val cmObj = CommentaryObject(ArrayList(), "Commentary Object 2")
    val observer3 = SMSUsers(cmObj, "Vasileios Davios [Greece]")
    val observer4 = SMSUsers(cmObj, "Keith Mannock [Uk]")
    observer3.subscribe()
    observer4.subscribe()
    println("-".repeat(40))
    cmObj.matchDetails("Starting Soccer Match [2018DEC03]")
    println("-".repeat(40))
    cmObj.matchDetails("Katsouranis sent off with a red card at 27'. Paok continues with 10")
    println("-".repeat(40))
    cmObj.matchDetails("Predrag Djordjevic scores for Olympiakos at 52'")
    println("-".repeat(40))
    observer3.unsubscribe()
    println("-".repeat(40))
    cmObj.matchDetails("Olympiakos win the match and it's the new Champion!!!")
    println("-".repeat(40))
    observer4.unsubscribe()

}