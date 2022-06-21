package ezProject

class CommonTest {

    fun createTaskList(): TaskList {

        var Task1 = Task("Task1")
        var Task2 = Task("Task2")
        var Task3 = Task("Task3")

        var tl = TaskList()
        tl.addTaskToList(Task1)
        tl.addTaskToList(Task2)
        tl.addTaskToList(Task3)

        return tl
    }
}
