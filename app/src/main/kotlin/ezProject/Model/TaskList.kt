package ezProject.model

public class TaskList {

    var TaskList = ArrayList<Task>()

    override fun toString(): String {
        return readTaskList()
    }

    fun readTaskList(): String {

        // print out all of the tasks in the list

        var listString = ""
        val tlIterator = TaskList.iterator()
        while (tlIterator.hasNext()) {

            listString += tlIterator.next()
            listString += "\n"
        }
        return listString
    }

    fun addTaskToList(t: Task) {
        // add task to List
        TaskList.add(t)
    }

    fun removeTaskFromList(t: Task?) {

        TaskList.remove(t)
    }

    fun findTask(taskName: String): Task? {

        val taskFind: Task? = TaskList.find { it.taskName == taskName }

        return taskFind
    }
}
