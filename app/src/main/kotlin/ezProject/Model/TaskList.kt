package ezProject.model

public class TaskList {

    var taskList = ArrayList<Task>()

    override fun toString(): String {
        return readTaskList()
    }

    fun readTaskList(): String {

        // print out all of the tasks in the list

        var listString = ""
        val tlIterator = taskList.iterator()
        while (tlIterator.hasNext()) {

            listString += tlIterator.next()
            listString += "\n"
        }
        return listString
    }

    fun addTaskToList(t: Task) {
        // add task to List
        taskList.add(t)
    }

    fun removeTaskFromList(t: Task?) {

        taskList.remove(t)
    }

    fun findTask(taskName: String): Task? {

        val taskFind: Task? = taskList.find { it.taskName == taskName }

        return taskFind
    }
}
