import data.Data
import util.*

class QueryParser {

    private fun determineRecordRemovalType(data: Data): DbAction {
        return when (data) {
            Data.Filter() -> DbAction.REMOVE_RECORD_BY_NAME
            Data.Id() -> DbAction.REMOVE_RECORD_BY_ID
            else -> DbAction.NONE
        }
    }

    private fun determineRecordListType(data: Data): DbAction {
        return when (data) {
            Data.None() -> DbAction.LIST_ALL_RECORDS
            Data.Filter() -> DbAction.LIST_RECORDS_BY_FILTER
            else -> DbAction.NONE
        }
    }

    private fun parseRecord(action: Action, data: Data): DbAction {
        return when (action) {
            Action.NEW -> DbAction.NEW_RECORD
            Action.ERASE -> determineRecordRemovalType(data)
            Action.REMOVE -> determineRecordRemovalType(data)
            Action.LIST -> determineRecordListType(data)
            Action.GET -> {
                if (data == Data.Id()) {
                    DbAction.GET_RECORD_FROM_ID
                } else {
                    DbAction.NONE
                }
            }

            else -> DbAction.NONE
        }
    }

    private fun parseTable(action: Action): DbAction {
        return when (action) {
            Action.NEW -> DbAction.NEW_TABLE
            Action.ERASE -> DbAction.ERASE_TABLE
            Action.REMOVE -> DbAction.REMOVE_TABLE
            Action.LIST -> DbAction.LIST_ALL_TABLES
            Action.GET -> DbAction.GET_TABLE_TYPE
            else -> DbAction.NONE
        }
    }

    private fun parseField(action: Action): DbAction {
        return when (action) {
            Action.AVG -> DbAction.AVERAGE_OF_FIELD
            Action.SUM -> DbAction.SUM_OF_FIELD
            Action.MAX -> DbAction.MAX_OF_FIELD
            Action.MIN -> DbAction.MIN_OF_FIELD
            else -> DbAction.NONE
        }
    }

    fun parse(query: Query): Command {
        val commandCategory = when (query.type) {
            Type.NONE -> "none"
            Type.TABLE -> "table"
            Type.FIELD -> "field"
            else -> "record"
        }

        val dbAction = when (commandCategory) {
            "table" -> parseTable(query.action)
            "record" -> parseRecord(query.action, query.data)
            "field" -> parseField(query.action)
            else -> DbAction.NONE
        }
        return Command(dbAction, query.table, query.data, query.type)
    }

}