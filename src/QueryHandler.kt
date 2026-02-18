import util.*
import java.sql.SQLException

/**
 * Responsible for handling queries to the database.
 *
 * Implements the functionality to allow for the easy undoing of actions,
 * in addition to being able to cancel a given write.
 */

class QueryHandler {
    val commandBuffer = mutableListOf<Command>()
    val database = Database()

    private fun queryParser(query: Query): Command {
        val commandCategory = when (query.type) {
            Type.NONE -> {
                "none"
            }
            Type.TABLE -> {
                "table"
            }
            else -> {
                "entry"
            }
        }

        commandCategory
    }

    private fun new() {}
    private fun erase() {}
    private fun remove() {}
    private fun list() {}
    private fun get() {}

    private fun addToBuffer(query: Query) {
        when (query.action) {
            Action.NEW -> new()
            Action.ERASE -> erase()
            Action.REMOVE -> remove()
            Action.LIST -> list()
            Action.GET -> get()
            else -> {}
        }
    }

    private fun writeBuffer() {
        commandBuffer.forEach { command ->
            database.execute(command)
        }
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
            Action.NONE -> {}
            Action.WRITE -> writeBuffer()
            Action.UNDO -> undoFromBuffer()
            Action.CANCEL_WRITE -> cancelBuffer()
            else -> addToBuffer(query)
        }
    }
}