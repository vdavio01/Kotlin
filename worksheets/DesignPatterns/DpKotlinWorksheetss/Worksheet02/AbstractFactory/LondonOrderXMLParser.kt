package Worksheet02.AbstractFactory

class LondonOrderXMLParser : XMLParser {
    override val parse: String
        get() =
            """London parsing Order XML...
                |London Order XML message
            """.trimMargin()

}


