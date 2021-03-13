fun printSpacer() {
    print("\n\n\n\n\n\n\n\n\n\n")
}

fun pause() {
    println("(Paused - Enter to continue)")
    readLine()
    printSpacer()
}

fun selectIntoList(list: List<Any>): Int {
    var input: String?
    do {
        list.forEachIndexed { index, item -> println("$index-$item") }
        input = readLine()
        try {
            val nbInput = input?.toInt(10)
            return nbInput ?: 0
        } catch (e: Exception) {
//                e.printStackTrace() // Debug
            println("Error during selection")
            continue
        }
    } while (true)
}