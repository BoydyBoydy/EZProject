package ezProject

import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class App {

    // fun main() {

    //     val task = Task("Task")
    //     println(task.toString())
    // }

}

fun main() {

    var view = View()
    var model = Model()
    var controller = ezProject.Controller(model, view)

    view.projectWindow(controller)
}
