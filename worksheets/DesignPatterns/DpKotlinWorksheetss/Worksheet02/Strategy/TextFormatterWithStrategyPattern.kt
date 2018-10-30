package Worksheet02.Strategy

fun main(args: Array<String>) {

    var formatter: TextFormatter = CapTextFormatter()
    var editor: TextEditor = TextEditor(formatter)
    editor.publishText("Testing text in caps formatter")
    formatter = LowerTextFormatter()
    editor = TextEditor(formatter)
    editor.publishText("Testing text in lower formatter")
}