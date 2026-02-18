package data

import util.Action
import util.Query
import util.Type
import workingTable

object Book {
    private fun makeInstance(title: String): Data.Book { return Data.Book(title) }

    fun new(title: String): Query {
        val data = makeInstance(title)
        return Query(Action.NEW, workingTable, data, Type.BOOK)
    }
}