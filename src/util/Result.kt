package util

import java.sql.ResultSet

data class Result(
    val resultSet: ResultSet? = null,
    val updateCount: Int
)
