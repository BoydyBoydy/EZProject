package ezProject

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TaskTest {

    @Test
    fun createAndReadTask() {

        // Create Task
        val task = Task("Test")
        println(task.readTask())

        // Update Task Name
        task.updateName("Task")
        println(task.readTask())

        // Test that the task has been created and that the taskname is correct
        assertEquals("Task", task.readTask())
    }

    @Test
    fun viewTaskList() {

        var tl = createTaskList()

        print(tl.toString())
        assertEquals("Task1\nTask2\nTask3\n", tl.toString())
    }

    @Test
    fun saveTask() {

        var d = Data()
        var filename = "C:/Temp/Test.txt"
        // create list
        var tl = createTaskList()

        /// write to File
        d.saveFile(filename, tl)

        // assert that file has been saved
        var f = File(filename)
        assertTrue(f.exists() && !f.isDirectory())

        // assert that the file has been saved with the correct information
        var tlFile = d.loadFile(filename)
        print(tlFile.toString())
        assertEquals("Task1\nTask2\nTask3\n", tlFile.toString())
    }

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
