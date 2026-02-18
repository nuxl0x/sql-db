import util.Command

/**
 * Primary database class.
 * Responsible for allowing changes to the database.
 *
 * Do NOT create instances of this class, it should never be directly interacted with.
 * Please instead use the provided functions to build and send queries to `QueryHandler`.
 */

class Database {
    fun execute(command: Command) {}

    // Does literally nothing.
    private fun none() {}

    private fun newEntry() {}

    private fun removeEntryByName() {}

    private fun removeEntryById() {}

    private fun listAllEntries() {}

    private fun listEntriesByFilter() {}

    private fun getEntryFromId() {}

    private fun newTable() {}

    private fun eraseTable() {}

    private fun removeTable() {}

    private fun listAllTables() {}

    private fun getTableType() {}
}