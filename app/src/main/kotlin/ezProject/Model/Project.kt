package ezProject.model

class Project {

    // holds all of the project information

    var taskList = TaskList()
    var fileNameDB = "C:/Temp/Prod/Prod.txt"

    fun readTaskList(): String {

        return taskList.readTaskList()
    }

    fun addTaskToTaskList(task: Task) {

        taskList.addTaskToList(task)
    }

    fun saveToFile() {

        var d = Data()

        /// write to File
        d.saveFile(fileNameDB, taskList)
    }

    fun deleteTaskList() {

        taskList = TaskList()
    }
}
