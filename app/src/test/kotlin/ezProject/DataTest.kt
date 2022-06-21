package ezProject

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

class DataTest {

    @Test
    fun saveTask() {

        var d = Data()
        var filename = "C:/Temp/Test.txt"
        // create list
        var ct = CommonTest()
        var tl = ct.createTaskList()

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

    @Test
    fun createData() {
        fail()
    }

    @Test
    fun readData() {
        fail()
    }

    @Test
    fun updateData() {
        fail()
    }

    @Test
    fun deleteData() {
        fail()
    }

    @Test
    fun saveDataToFile() {
        fail()
    }
}
