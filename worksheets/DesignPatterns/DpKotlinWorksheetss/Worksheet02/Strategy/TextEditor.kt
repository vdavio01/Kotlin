package Worksheet02.Strategy

class TextEditor(val formatter: TextFormatter) {


    fun publishText(text: String) {
        formatter.format(text)
    }
}