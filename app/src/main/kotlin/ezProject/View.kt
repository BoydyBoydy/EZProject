package ezProject

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

class View {

    lateinit var controller: Controller

     // TODO update all of the click functionality into the controller

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
    fun projectWindow(controller: Controller) = application {
        var action by remember { mutableStateOf("Last action: None") }

        addListener(controller)

        Window(
                onCloseRequest = ::exitApplication,
                title = "EZProject",
                state = WindowState(width = 1300.dp, height = 750.dp)
        ) {
            Column {
                TextButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
                    Text(text = "Text Button")
                }
            }

            MenuBar {
                Menu("Tasks", mnemonic = 'T') {
                    Item(
                            "Create new Task",
                            onClick = { action = "Last action: Create new Task" },
                            shortcut = KeyShortcut(Key.C, ctrl = true)
                    )
                }
                Menu("Views", mnemonic = 'V') {
                    Item(
                            "Task List",
                            onClick = { action = "Last action: Task List" },
                            shortcut = KeyShortcut(Key.C, ctrl = true)
                    )
                    Item(
                            "Gantt Chart",
                            onClick = { action = "Last action: Gantt Chart" },
                            shortcut = KeyShortcut(Key.V, ctrl = true)
                    )
                    Item(
                            "Kanban Board",
                            onClick = { action = "Last action: Kanban Board" },
                            shortcut = KeyShortcut(Key.V, ctrl = true)
                    )
                }
                Menu("Resources", mnemonic = 'R') {
                    Item(
                            "Create Resources",
                            onClick = { action = "Last action: Create Resources" },
                            shortcut = KeyShortcut(Key.C, ctrl = true)
                    )
                }
                Menu("Costs", mnemonic = 'C') {
                    Item(
                            "Create Costs",
                            onClick = { action = "Last action: Create Costs" },
                            shortcut = KeyShortcut(Key.C, ctrl = true)
                    )
                }
                Menu("Baselines", mnemonic = 'B') {
                    Item(
                            "Create Baseline",
                            onClick = { action = "Last action: Create Baseline" },
                            shortcut = KeyShortcut(Key.C, ctrl = true)
                    )
                }

                // Menu("Actions", mnemonic = 'A') {
                //     CheckboxItem(
                //             "Advanced settings",
                //             checked = isSubmenuShowing,
                //             onCheckedChange = { isSubmenuShowing = !isSubmenuShowing }
                //     )
                //     if (isSubmenuShowing) {
                //         Menu("Settings") {
                //             Item("Setting 1", onClick = { action = "Last action: Setting 1" })
                //             Item("Setting 2", onClick = { action = "Last action: Setting 2" })
                //         }
                //     }
                //     Separator()
                //     Item("About", icon = TrayIcon, onClick = { action = "Last action: About" })
                //     Item(
                //             "Exit",
                //             onClick = { isOpen = false },
                //             shortcut = KeyShortcut(Key.Escape),
                //             mnemonic = 'E'
                //     )
                // }
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = action)
            }
        }
    }
}
