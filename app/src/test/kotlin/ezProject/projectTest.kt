package ezProject

import kotlin.test.Test
import kotlin.test.fail
import kotlin.test.assertEquals

class projectTest {

    @Test
    fun createTask() {

        // Create Task
        val task = Task("Test")
        println(task.toString())
    
        //Update Task Name
        task.updateName("Task")
        println(task.toString())

        assertEquals("Task", task.toString())

    }

    @Test
    fun viewTaskList() {

        var Task1 = Task("Task1")
        var Task2 = Task("Task2")
        var Task3 = Task("Task3")
        
        var tl = TaskList()
        tl.addTaskToList(Task1)
        tl.addTaskToList(Task2)
        tl.addTaskToList(Task3)

        print(tl.toString())
        assertEquals("Task1\nTask2\nTask3\n", tl.toString())

    }

    @Test
    fun saveTask() {
        fail()
    }
}
