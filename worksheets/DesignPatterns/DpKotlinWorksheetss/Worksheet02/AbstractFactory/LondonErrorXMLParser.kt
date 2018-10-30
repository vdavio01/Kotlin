package Worksheet02.AbstractFactory

class LondonErrorXMLParser: XMLParser {
    override val parse: String
        get() = """London parsing Error XML...
            |London Error XML message
        """.trimMargin()

}