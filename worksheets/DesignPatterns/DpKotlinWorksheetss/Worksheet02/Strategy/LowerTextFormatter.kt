package Worksheet02.Strategy

class LowerTextFormatter: TextFormatter {
    override fun format(text: String) {
        println(text.toLowerCase())
    }


}