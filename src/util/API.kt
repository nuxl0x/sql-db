package util

import util.data.Entry
import util.data.EntryType
import util.data.Query

enum class API(val exec: (table: String, entry: Entry, entryType: EntryType) -> Query) {
    CREATE_ENTRY(
        fun(table: String, entry: Entry, entryType: EntryType): Query {
            return Query(Category.ENTRY, table)
        }
    ),
}