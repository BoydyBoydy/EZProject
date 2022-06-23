package ezProject

class Controller(model: Model, view: View) {

    var model: Model
    var view: View

    init {

        this.model = model
        this.view = view
        this.view.addListener(this)
    }
}
