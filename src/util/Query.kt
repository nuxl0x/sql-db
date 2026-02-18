package util

import data.Data
import util.Type

data class Query(
    val action: Action = Action.NONE,
    val table: String = "",
    val data: Data = Data.None(),
    val type: Type = Type.NONE
    )