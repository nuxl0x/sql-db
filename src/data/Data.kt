package data

sealed interface Data {
    data class None(val none: String = "") : Data
    data class Filter(val filter: String = "") : Data

    // Entry Classes
    data class Book(val title: String = "") : Data
}