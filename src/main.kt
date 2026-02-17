import util.API
import util.data.Entry
import util.data.EntryType

fun main() {
    val book = Entry.Book("Harry Potter")
    val query = API.CREATE_ENTRY.exec("books", book, EntryType.BOOK)
    println(query)
}