package Worksheet02.AbstractFactory

class NYCOrderXMLParser: XMLParser{
    override val parse: String
        get() = """NYC parsing Order XML...
            |NYC Order XML message
        """.trimMargin()

}