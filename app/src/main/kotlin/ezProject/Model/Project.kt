package ezProject.model

class Project {

    // holds all of the project information

    var tl = TaskList()
    var fileNameDB = "C:/Temp/Prod/Prod.txt"

    fun readTaskList(): String {
        return tl.readTaskList()
    }

    fun addTaskToTaskList(task: Task) {

        tl.addTaskToList(task)
    }

    fun saveToFile() {

        var d = Data()

        /// write to File
        d.saveFile(fileNameDB, tl)
    }

    fun deleteTaskList() {

        tl = TaskList()
    }
}
