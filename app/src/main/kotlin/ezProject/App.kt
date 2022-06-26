package ezProject

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ezProject.navcontroller.NavController
import ezProject.navcontroller.NavigationHost
import ezProject.navcontroller.composable
import ezProject.navcontroller.rememberNavController
import ezProject.screens.HomeScreen
import ezProject.screens.NotificationScreen
import ezProject.screens.TaskScreen


@Composable
@Preview
fun App() {

    val screens = Screen.values().toList()
    val navController by rememberNavController(Screen.HomeScreen.name)
    val currentScreen by remember { navController.currentScreen }

    MaterialTheme {
        Surface(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
            Box(modifier = Modifier.fillMaxSize()) {
                NavigationRail(modifier = Modifier.align(Alignment.CenterStart).fillMaxHeight()) {
                    screens.forEach {
                        NavigationRailItem(
                                selected = currentScreen == it.name,
                                icon = {
                                    Icon(imageVector = it.icon, contentDescription = it.label)
                                },
                                label = { Text(it.label) },
                                alwaysShowLabel = false,
                                onClick = { navController.navigate(it.name) }
                        )
                    }
                }

                Box(modifier = Modifier.fillMaxHeight()) {
                    CustomNavigationHost(navController = navController)
                }
            }
        }
    }
}

fun main() = application { Window(onCloseRequest = ::exitApplication) { App() } }

/** Sidebar - Screens */
enum class Screen(val label: String, val icon: ImageVector) {
    HomeScreen(label = "Home", icon = Icons.Filled.Home),
    NotificationsScreen(label = "Notifications", icon = Icons.Filled.Notifications),
    TaskScreen(label = "Task", icon = Icons.Filled.VerifiedUser)
    // SettingsScreen(label = "Settings", icon = Icons.Filled.Settings),
    // ProfileScreens(label = "User Profile", icon = Icons.Filled.VerifiedUser)
}

@Composable
fun CustomNavigationHost(navController: NavController) {
    NavigationHost(navController) {
                composable(Screen.HomeScreen.name) { HomeScreen(navController) }

                composable(Screen.NotificationsScreen.name) { NotificationScreen(navController) }

                composable(Screen.TaskScreen.name) { TaskScreen(navController) }

                // composable(Screen.SettingsScreen.name) { SettingScreen(navController) }

                // composable(Screen.ProfileScreens.name) { ProfileScreen(navController) }
            }
            .build()
}




//Current
// import androidx.compose.foundation.layout.Box
// import androidx.compose.foundation.layout.Column
// import androidx.compose.foundation.layout.fillMaxSize
// import androidx.compose.foundation.layout.padding
// import androidx.compose.material.*
// import androidx.compose.runtime.Composable
// import androidx.compose.runtime.getValue
// import androidx.compose.runtime.mutableStateOf
// import androidx.compose.runtime.setValue
// import androidx.compose.ui.Alignment
// import androidx.compose.ui.Modifier
// import androidx.compose.ui.unit.dp
// import androidx.compose.ui.window.MenuBar
// import androidx.compose.ui.window.Window
// import androidx.compose.ui.window.WindowState
// import androidx.compose.ui.window.application
// import androidx.compose.ui.window.rememberWindowState
// import com.arkivanov.decompose.ExperimentalDecomposeApi
// import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
// import com.arkivanov.essenty.lifecycle.LifecycleRegistry

// class App {

//     // fun main() {

//     //     val task = Task("Task")
//     //     println(task.toString())
//     // }

// }

// @OptIn(ExperimentalComposeUiApi::class)
// @OptIn(com.arkivanov.decompose.ExperimentalDecomposeApi::class)
// fun main() {
//     val lifecycle = LifecycleRegistry()

//     application {
//         val windowState = rememberWindowState()
//         var action by mutableStateOf("Last action: None")

//         LifecycleController(lifecycle, windowState)

//         Window(
//                 onCloseRequest = ::exitApplication,
//                 title = "EZProject",
//                 state = WindowState(width = 1300.dp, height = 750.dp)
//         ) {
//             Column() {
//                 TextButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
//                     Text(text = "Change View")
//                 }
//             } // view.setSecond()
//             MenuBar {
//                 Menu("Tasks", mnemonic = 'T') {
//                     Item(
//                             "Create new Task",
//                             onClick = { action = "Last action: Create new Task" },
//                             // shortcut = KeyShortcut(Key.C, ctrl = true)
//                             )
//                 }
//                 Menu("Views", mnemonic = 'V') {
//                     Item(
//                             "Task List",
//                             onClick = { action = "Last action: Task List" },
//                             // shortcut = KeyShortcut(Key.C, ctrl = true)
//                             )
//                     Item(
//                             "Gantt Chart",
//                             onClick = { action = "Last action: Gantt Chart" },
//                             // shortcut = KeyShortcut(Key.V, ctrl = true)
//                             )
//                     Item(
//                             "Kanban Board",
//                             onClick = { action = "Last action: Kanban Board" },
//                             // shortcut = KeyShortcut(Key.V, ctrl = true)
//                             )
//                 }
//                 Menu("Resources", mnemonic = 'R') {
//                     Item(
//                             "Create Resources",
//                             onClick = { action = "Last action: Create Resources" },
//                             // shortcut = KeyShortcut(Key.C, ctrl = true)
//                             )
//                 }
//                 Menu("Costs", mnemonic = 'C') {
//                     Item(
//                             "Create Costs",
//                             onClick = { action = "Last action: Create Costs" },
//                             // shortcut = KeyShortcut(Key.C, ctrl = true)
//                             )
//                 }
//                 Menu("Baselines", mnemonic = 'B') {
//                     Item(
//                             "Create Baseline",
//                             onClick = { action = "Last action: Create Baseline" },
//                             // shortcut = KeyShortcut(Key.C, ctrl = true)
//                             )
//                 }
//             }
//             Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                 Text(text = action)
//             }
//         }
//     }
// }

//Original
// @OptIn(ExperimentalComposeUiApi::class)
// fun main() = application {
//     var view = View()
//     var model = Model()
//     var controller = ezProject.Controller(model, view)
//     view.projectWindow(controller)

//     var action by mutableStateOf("Last action: None")

    // Window(
    //         onCloseRequest = ::exitApplication,
    //         title = "EZProject",
    //         state = WindowState(width = 1300.dp, height = 750.dp)
    // ) {
    //     Column() {
    //         TextButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
    //             Text(text = "Change View")
    //         }
    //     } // view.setSecond()
    //     MenuBar {
    //         Menu("Tasks", mnemonic = 'T') {
    //             Item(
    //                     "Create new Task",
    //                     onClick = { action = "Last action: Create new Task" },
    //                     shortcut = KeyShortcut(Key.C, ctrl = true)
    //             )
    //         }
    //         Menu("Views", mnemonic = 'V') {
    //             Item(
    //                     "Task List",
    //                     onClick = { action = "Last action: Task List" },
    //                     shortcut = KeyShortcut(Key.C, ctrl = true)
    //             )
    //             Item(
    //                     "Gantt Chart",
    //                     onClick = { action = "Last action: Gantt Chart" },
    //                     shortcut = KeyShortcut(Key.V, ctrl = true)
    //             )
    //             Item(
    //                     "Kanban Board",
    //                     onClick = { action = "Last action: Kanban Board" },
    //                     shortcut = KeyShortcut(Key.V, ctrl = true)
    //             )
    //         }
    //         Menu("Resources", mnemonic = 'R') {
    //             Item(
    //                     "Create Resources",
    //                     onClick = { action = "Last action: Create Resources" },
    //                     shortcut = KeyShortcut(Key.C, ctrl = true)
    //             )
    //         }
    //         Menu("Costs", mnemonic = 'C') {
    //             Item(
    //                     "Create Costs",
    //                     onClick = { action = "Last action: Create Costs" },
    //                     shortcut = KeyShortcut(Key.C, ctrl = true)
    //             )
    //         }
    //         Menu("Baselines", mnemonic = 'B') {
    //             Item(
    //                     "Create Baseline",
    //                     onClick = { action = "Last action: Create Baseline" },
    //                     shortcut = KeyShortcut(Key.C, ctrl = true)
    //             )
    //         }

    //         // Menu("Actions", mnemonic = 'A') {
    //         //     CheckboxItem(
    //         //             "Advanced settings",
    //         //             checked = isSubmenuShowing,
    //         //             onCheckedChange = { isSubmenuShowing = !isSubmenuShowing }
    //         //     )
    //         //     if (isSubmenuShowing) {
    //         //         Menu("Settings") {
    //         //             Item("Setting 1", onClick = { action = "Last action: Setting 1"
    //         // })
    //         //             Item("Setting 2", onClick = { action = "Last action: Setting 2"
    //         // })
    //         //         }
    //         //     }
    //         //     Separator()
    //         //     Item("About", icon = TrayIcon, onClick = { action = "Last action: About"
    //         // })
    //         //     Item(
    //         //             "Exit",
    //         //             onClick = { isOpen = false },
    //         //             shortcut = KeyShortcut(Key.Escape),
    //         //             mnemonic = 'E'
    //         //     )
    //         // }

    //     }
    //     Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    //         Text(text = action)
    //     }
    // }
// }
