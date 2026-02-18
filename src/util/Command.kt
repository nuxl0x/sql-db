package util

import data.Data

data class Command(
    val dbAction: DbAction,
    val table: String,
    val data: Data,
    val type: Type
)
