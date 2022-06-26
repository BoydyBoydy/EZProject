package ezProject.model

class Project {

    // holds all of the project information

    var tl = TaskList()

    fun readTaskList(): String {
        return tl.readTaskList()
    }
}
