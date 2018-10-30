package Worksheet02.AbstractFactory

class NYCFeedBackXMLParser: XMLParser{
    override val parse: String
        get() = """NYC parsing Feedback XML...
            |NYC Feedback XML message
        """.trimMargin()

}