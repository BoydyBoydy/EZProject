package ezProject

import java.io.File

public class Data{

    
    fun saveFile(filename: String, tasklist : TaskList) {
        //save Task List to file

        val file = File(filename)

        //write tasklist to file
        file.writeText(tasklist.toString())

        
    }

    fun loadFile(filename : String) : TaskList{
        // Load Task File from file
        var tl = TaskList()
        var fileLines = readFile(filename)
        fileLines.forEach {
            tl.addTaskToList(Task(it)) 
        }
        
        return tl

    }

    fun readFile(fileName: String): List<String>
  = File(fileName).bufferedReader().readLines()
}
