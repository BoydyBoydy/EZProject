package ezProject.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ezProject.controller.NavController
import ezProject.model.Project
import ezProject.model.Task

@Composable
fun TaskScreen(navController: NavController, project: Project) {
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(navController.currentScreen.value)
        Button(onClick = { navController.navigate(ezProject.Screen.HomeScreen.name) }) {
            Text("Navigate to Home")
        }

        Button(onClick = { project.addTaskToTaskList(Task("New Task")) }) {
            Text("Create New Task")
        }

        Button(onClick = { project.saveToFile() }) { Text("Save List to File") }

        Button(onClick = { project.deleteTaskList() }) { Text("Remove List") }

        Button(onClick = { navController.navigate(ezProject.Screen.TaskListScreen.name) }) {
            Text("View List")
        }
    }
}
