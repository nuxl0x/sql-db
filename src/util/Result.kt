package util

import java.sql.ResultSet

data class Result(
    var resultSet: ResultSet? = null,
    var updateCount: Int
)
