package util

enum class Action {
    NONE,
    WRITE,
    UNDO,
    CANCEL_WRITE,

    NEW,
    ERASE,
    REMOVE,
    LIST,
    GET
}