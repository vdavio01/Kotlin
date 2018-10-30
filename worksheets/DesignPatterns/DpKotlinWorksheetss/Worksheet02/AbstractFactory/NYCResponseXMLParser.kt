package Worksheet02.AbstractFactory

class NYCResponseXMLParser: XMLParser {
    override val parse: String
        get() = """NYC parsing Response XML...
            |NYC Response XML message
        """.trimMargin()

}