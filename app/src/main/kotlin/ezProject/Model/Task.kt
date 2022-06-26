package ezProject.model

public class Task {

    var taskName = ""

    constructor(name: String) {

        updateName(name)
    }

    override fun toString(): String {
        return readTask()
    }

    fun readTask() : String {
        return taskName
    }

    fun updateName(name: String) {
        taskName = name
    }
}
