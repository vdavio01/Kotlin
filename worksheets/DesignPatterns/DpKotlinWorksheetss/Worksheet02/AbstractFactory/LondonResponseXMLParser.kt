package Worksheet02.AbstractFactory

class LondonResponseXMLParser : XMLParser {
    override val parse: String
        get() = """London parsing Response XML...
            |London Response XML message
        """.trimMargin()

}
