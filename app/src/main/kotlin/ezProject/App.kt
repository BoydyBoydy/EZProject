package ezProject

import ezProject.Task

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }

    fun main() {

        println(App().greeting)

        val task = Task("Task")
        println(task.toString())
    }

}


