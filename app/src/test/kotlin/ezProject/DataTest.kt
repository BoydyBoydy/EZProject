package ezProject

import ezProject.model.Data
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class DataTest {

    val fileNameTest = "C:/Temp/Test/Test.txt"
    val fileNameEmpty = "C:/Temp/Test/empty.txt"

    @Test
    fun saveTask() {

        var d = Data()
        var filename = fileNameTest
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
    fun loadEmptyOrNonExistingFile() {
        // check that the file is empty and or existing
        // parse an exception in this case

        var d = Data()

        // fake file - what happens - FNF / IO
        val fileFake = ""
        assertFailsWith<FileNotFoundException>() {
            var tlFile = d.loadFile(fileFake)
            println(tlFile.toString())
        }

        // file found, but empty
        val fileEmpty = fileNameEmpty
        assertFailsWith<IOException>() {
            var tlFile = d.loadFile(fileEmpty)
            println(tlFile.toString())
        }
    }
}
