import util.*

/**
 * Responsible for handling queries to the database.
 *
 * Implements the functionality to allow for the easy undoing of actions,
 * in addition to being able to cancel a given write.
 *
 * If you wish to bypass this functionality, feel free to make a custom handler for queries.
 * It is important to note that the Database will only accept a `Command()` as the input.
 */

class QueryHandler {
    val commandBuffer = mutableListOf<Command>()
    val database = Database()
    val parser = QueryParser()

    private fun addToBuffer(query: Query) {
        val command = parser.parse(query)
        commandBuffer.add(command)
    }

    private fun writeBuffer() {
        commandBuffer.forEach { command ->
            database.execute(command)
        }
        cancelBuffer()
    }

    private fun undoFromBuffer() {
        commandBuffer.removeLast()
    }

    private fun cancelBuffer() {
        commandBuffer.clear()
    }

    /**
     * The only way to interact with the query handler.
     *
     * For the protection of the internal methods, to ensure proper handling.
     */
    fun query(query: Query) {
        when (query.action) {
            Action.WRITE -> writeBuffer()
            Action.UNDO -> undoFromBuffer()
            Action.CANCEL_WRITE -> cancelBuffer()
            else -> addToBuffer(query)
        }
    }

}