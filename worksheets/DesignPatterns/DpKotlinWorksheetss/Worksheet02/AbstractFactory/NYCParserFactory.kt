package Worksheet02.AbstractFactory

class NYCParserFactory : AbstractParserFactory {
    override fun getParserInstance(parserType: String): XMLParser {
        return when{
            parserType.toUpperCase() == "NYCERROR" -> NYCErrorXMLParser()
            parserType.toUpperCase() == "NYCFEEDBACK" -> NYCFeedBackXMLParser()
            parserType.toUpperCase() == "NYCORDER" -> NYCOrderXMLParser()
            parserType.toUpperCase() == "NYCRESPONSE" -> NYCResponseXMLParser()
            else -> throw Exception("Invalid Parser")
        }
    }
}