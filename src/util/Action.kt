package util

/**
 * **Enum Action**
 *
 * Responsible for providing a user of the API with an easy list of all available actions on the database,
 * including write actions, which are handled through `QueryHandler`.
 */

enum class Action {
    // System Actions
    NONE,
    WRITE,
    UNDO,
    CANCEL_WRITE,

    // Record/Table Actions
    NEW,
    ERASE,
    REMOVE,
    LIST,
    GET,

    // Field Actions
    AVG,
    SUM,
    MAX,
    MIN
}