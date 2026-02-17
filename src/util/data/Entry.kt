package util.data

/**
 * **Entry Interface**
 *
 * Responsible for managing all valid database entry types.
 * Tables will be assigned an entry type when created, and you will be able to write any other entry type.
 *
 * Any changes in here MUST be replicated in `EntryType`.
 */

sealed interface Entry {
    data class None(val none: String = "None") : Entry
    data class Book(val title: String) : Entry
}