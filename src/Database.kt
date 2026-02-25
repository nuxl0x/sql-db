import util.Command
import util.DbAction
import util.Result
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

/**
 * Primary database class.
 * Responsible for allowing changes to the database.
 *
 * Do NOT create instances of this class, it should never be directly interacted with.
 * Please instead use the provided functions to build and send queries to `QueryHandler`.
 */

class Database {
    val fileReader = FileReader()

    fun execute(command: Command) {
        when (command.dbAction) {
            DbAction.NONE -> none(command)
            DbAction.NEW_RECORD -> newRecord(command)
            DbAction.REMOVE_RECORD_BY_NAME -> removeRecordByName(command)
            DbAction.REMOVE_RECORD_BY_ID -> removeRecordById(command)
            DbAction.LIST_ALL_RECORDS -> listAllRecords(command)
            DbAction.LIST_RECORDS_BY_FILTER -> listRecordsByFilter(command)
            DbAction.GET_RECORD_FROM_ID -> getRecordFromId(command)
            DbAction.AVERAGE_OF_FIELD -> avgField(command)
            DbAction.SUM_OF_FIELD -> sumField(command)
            DbAction.MAX_OF_FIELD -> maxField(command)
            DbAction.MIN_OF_FIELD -> minField(command)
            DbAction.NEW_TABLE -> newTable(command)
            DbAction.ERASE_TABLE -> eraseTable(command)
            DbAction.REMOVE_TABLE -> removeTable(command)
            DbAction.LIST_ALL_TABLES -> listAllTables(command)
            DbAction.GET_TABLE_TYPE -> getTableType(command)
        }
    }

    private fun run(sql: String): Result {
        val result = Result(null, 0)
        val connection: Connection = DriverManager.getConnection(fileReader.getDatabaseUrl())
        connection.use { connection ->
            connection.createStatement().use { statement ->
                statement.executeQuery(sql)
                result.resultSet = statement.resultSet
                result.updateCount = statement.updateCount
            }
        }
        return result
    }

    // Does literally nothing.
    private fun none(command: Command) {}

    private fun newRecord(command: Command) {}

    private fun removeRecordByName(command: Command) {}

    private fun removeRecordById(command: Command) {}

    private fun listAllRecords(command: Command) {}

    private fun listRecordsByFilter(command: Command) {}

    private fun getRecordFromId(command: Command) {}

    private fun avgField(command: Command) {}

    private fun sumField(command: Command) {}

    private fun minField(command: Command) {}

    private fun maxField(command: Command) {}

    private fun newTable(command: Command) {}

    private fun eraseTable(command: Command) {}

    private fun removeTable(command: Command) {}

    private fun listAllTables(command: Command) {}

    private fun getTableType(command: Command) {}
}