package ezProject

import androidx.compose.runtime.Composable

class Controller(model: Model, view: View) {

    var model: Model
    var view: View

    init {

        this.model = model
        this.view = view
        this.view.addListener(this)
    }

    fun updateView() {
        // view.printoutdetails, etc.
        // view.
    }

    @Composable
    fun switchSecond(controller: Controller) {

        view.secondWindow(controller)
    }

    // fun setView(viewNew: View) {
    //     // change view
    //     this.view = viewNew
    // }

    fun actionPerformed() {
        // action performed means a change is needed - this should be read from the view event

    }

    // fun onEvent(event : Event){
    //     //on event - print ln
    // }
}
