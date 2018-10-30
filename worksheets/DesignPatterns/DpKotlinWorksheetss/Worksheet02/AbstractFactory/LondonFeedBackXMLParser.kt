package Worksheet02.AbstractFactory

class LondonFeedBackXMLParser : XMLParser {
    override val parse: String
        get() = """London Parsing Feedback XML...
            |London Feedback XML Message
        """.trimMargin()

}