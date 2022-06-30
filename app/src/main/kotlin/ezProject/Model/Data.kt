package ezProject.model

import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

public class Data {

    fun saveFile(filename: String, tasklist: TaskList) {
        // save Task List to file

        val file = File(filename)

        // write tasklist to file
        file.writeText(tasklist.toString())
    }

    fun loadFile(filename: String): TaskList {
        // Load Task File from file

        var tl = TaskList()
        try {
            var fileLines = readFile(filename)

            fileLines.forEach { tl.addTaskToList(Task(it)) }
        } catch (e: IOException) {
            println("IO Exception")
            throw IOException("File Empty or Not Found")
        } catch (e: FileNotFoundException) {
            println("FileNotFoundException")
            throw IOException("File Not Found")
        }

        return tl
    }

    fun readFile(fileName: String): List<String> {

        // file exists check
        var f = File(fileName)
        if (!f.exists() && f.isDirectory()) {
            throw IOException("File Path does not exist or File is empty")
        }

        if (f.length() == 0L) {
            throw IOException("File is empty")
        }

        return File(fileName).bufferedReader().readLines()
    }
}
