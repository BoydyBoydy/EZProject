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

        Button(onClick = {}) { Text("Create New Task") }

        Button(onClick = {}) { Text("Save List") }

        Button(onClick = {}) { Text("Remove List") }

        Button(onClick = { println(project.readTaskList()) }) { Text("View List") }
    }
}
