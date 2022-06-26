package ezProject

import ezProject.model.Task
import ezProject.model.TaskList
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class TaskTest {

    // Task
    @Test
    fun createReadUpdateTask() {

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
    fun deleteTask() {
        // from TaskList

        var tl: TaskList = createTestList()
        println(tl.readTaskList())
        val task = tl.findTask("Task2")

        tl.removeTaskFromList(task)
        println()
        println(tl.readTaskList())

        var testArray = TaskList()
        testArray.addTaskToList(Task("Task1"))
        testArray.addTaskToList(Task("Task3"))
        assertEquals(testArray.toString(), tl.readTaskList())
    }

    // Task List
    @Test
    fun createReadUpdateTaskList() {

        var tl = createTestList()

        print(tl.readTaskList())
        assertEquals("Task1\nTask2\nTask3\n", tl.readTaskList())
    }

    @Test
    fun deleteTaskList() {
        // Might not need to delete from memory and just leave it as is
        // but might also want to see what happens when you delete it through the Data Management
        // Functions :)

        var tl = createTestList()
        tl.readTaskList()

        fail()
    }

    // creates Test List
    fun createTestList(): TaskList {
        var ct = CommonTest()
        var tl = ct.createTaskList()

        return tl
    }
}
