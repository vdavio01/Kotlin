package Worksheet02.AbstractFactory

class LondonParserFactory: AbstractParserFactory {

    override fun getParserInstance(parserType: String): XMLParser {
       return when{
            parserType.toUpperCase() == "LONDONERROR" -> LondonErrorXMLParser()
            parserType.toUpperCase() == "LONDONFEEDBACK" -> LondonFeedBackXMLParser()
            parserType.toUpperCase() == "LONDONORDER" -> LondonOrderXMLParser()
            parserType.toUpperCase() == "LONDONRESPONSE" -> LondonResponseXMLParser()
            else -> throw Exception("Invalid Parser")
        }
    }
}