package ezProject

class Model {

    //data
    //logic

    lateinit var taskList: TaskList

    fun Model() {

        var Task1 = Task("Task1")
        var Task2 = Task("Task2")
        var Task3 = Task("Task3")

        var taskList = TaskList()
        taskList.addTaskToList(Task1)
        taskList.addTaskToList(Task2)
        taskList.addTaskToList(Task3)
    }
}
