package Worksheet02.Strategy

class CapTextFormatter: TextFormatter {
    override fun format(text: String) {
        println(text.toUpperCase())
    }
}