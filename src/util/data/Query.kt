package util.data

import util.Category

data class Query(
    val category: Category = Category.GLOBAL,
    val table: String = "",
    val entry: Entry = Entry.None(),
    val entryType: EntryType = EntryType.NONE,
    )