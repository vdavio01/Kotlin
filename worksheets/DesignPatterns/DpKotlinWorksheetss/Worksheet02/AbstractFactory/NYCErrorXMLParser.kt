package Worksheet02.AbstractFactory

class NYCErrorXMLParser: XMLParser {
    override val parse: String
        get() = """NYC parsing Error XML...
            |NYC Error XML message
        """.trimMargin()

}