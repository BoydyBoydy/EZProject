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
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ezProject.controller.NavController
import ezProject.controller.NavigationHost
import ezProject.controller.composable
import ezProject.controller.rememberNavController
import ezProject.model.Project
import ezProject.view.HomeScreen
import ezProject.view.NotificationScreen
import ezProject.view.TaskListScreen
import ezProject.view.TaskScreen

@Composable
@Preview
fun App() {

    val screens = Screen.values().toList()
    val navController by rememberNavController(Screen.HomeScreen.name)
    val currentScreen by remember { navController.currentScreen }
    val project = Project()

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
                    CustomNavigationHost(navController = navController, project)
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "EZProject") {
        MenuBar {
            Menu("Tasks", mnemonic = 'T') { Item("Create new Task", onClick = {}) }
            Menu("Views", mnemonic = 'V') {
                Item("Task List", onClick = {})
                Item("Gantt Chart", onClick = {})
                Item("Kanban Board", onClick = {})
            }
            Menu("Resources", mnemonic = 'R') { Item("Create Resources", onClick = {}) }
            Menu("Costs", mnemonic = 'C') { Item("Create Costs", onClick = {}) }
            Menu("Baselines", mnemonic = 'B') { Item("Create Baseline", onClick = {}) }
        }

        App()
    }
}

/** Sidebar - Screens */
enum class Screen(val label: String, val icon: ImageVector) {
    HomeScreen(label = "Home", icon = Icons.Filled.Home),
    NotificationsScreen(label = "Notifications", icon = Icons.Filled.Notifications),
    TaskScreen(label = "Task", icon = Icons.Filled.VerifiedUser),
    TaskListScreen(label = "Task List", icon = Icons.Filled.VerifiedUser)
}

@Composable
fun CustomNavigationHost(navController: NavController, project: Project) {
    NavigationHost(navController) {
                composable(Screen.HomeScreen.name) { HomeScreen(navController) }

                composable(Screen.NotificationsScreen.name) { NotificationScreen(navController) }

                composable(Screen.TaskScreen.name) { TaskScreen(navController, project) }

                composable(Screen.TaskListScreen.name) { TaskListScreen(navController, project) }
            }
            .build()
}
