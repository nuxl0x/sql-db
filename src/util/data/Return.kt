package util.data

import java.sql.ResultSet

data class Return(
    val resultSet: ResultSet? = null,
    val updateCount: Int
)
