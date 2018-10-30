package Worksheet02.AbstractFactory

interface AbstractParserFactory {
    fun getParserInstance(parserType: String): XMLParser
}