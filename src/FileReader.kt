import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

class FileReader {
    val userHome: String = System.getProperty("user.home")
    val dbFolder = File(userHome, "Documents/sql-db")
    val settingsFile = File(dbFolder, "settings.txt")

    fun getDatabaseUrl(): String {
        val settings = getSettingsList()
        val databasePath: Path = Paths.get(System.getProperty("user.home"), fetchDbUrl(settings))
        return "jbdc:sqlite:$databasePath"
    }

    private fun getSettingsList(): MutableList<String> {
        val settings = mutableListOf<String>()
        settingsFile.forEachLine { line ->
            settings.add(line)
        }
        return settings
    }

    private fun fetchDbUrl(settings: MutableList<String>): String {
        var final = ""
        settings.forEach { line ->
            val splitLineList = line.split("=")
            if (splitLineList[0] == "db_file_location") {
                final = splitLineList[1]
            }
        }
        return final
    }
}