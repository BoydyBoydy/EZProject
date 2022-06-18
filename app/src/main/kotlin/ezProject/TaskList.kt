package ezProject

public class TaskList {

    var TaskList = ArrayList<Task>()

    override fun toString(): String {
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
}
