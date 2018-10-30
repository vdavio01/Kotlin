package Worksheet02.AbstractFactory

object ParserFactoryProducer {
    fun getFactory(s: String): AbstractParserFactory {
        return when {
            s.toUpperCase() == "LONDONFACTORY" -> LondonParserFactory()
            s.toUpperCase() == "NYCFACTORY" -> NYCParserFactory()
            else -> {
                throw Exception("We are currently servicing clients from New York and London only ")

            }

        }
    }
}