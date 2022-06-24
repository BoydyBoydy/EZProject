package ezProject

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

class View {

    lateinit var controller: Controller

    // TODO update all of the click functionality into the controller

    fun View(controller: Controller) {
        addListener(controller)
    }

    fun addListener(controller: Controller) {
        this.controller = controller
    }

    object TrayIcon : Painter() {
        override val intrinsicSize = Size(256f, 256f)

        override fun DrawScope.onDraw() {
            drawOval(Color(0xFFFFA500))
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun projectWindow(controller: Controller) {

        addListener(controller)
        

    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun secondWindow(controller: Controller) {
        var action by mutableStateOf("Last action: None")

        addListener(controller)

        Column {
            TextButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
                Text(text = "View should have changed!")
            }
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = action)
        }
    }
    @Composable
    fun setSecond() {

        controller.switchSecond(controller)
    }

    // different views -- TaskList, Resources, Costs, etc.

}
