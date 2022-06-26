package ezProject.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ezProject.controller.NavController
import ezProject.model.Project

@Composable
fun TaskListScreen(navController: NavController, project: Project) {
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(navController.currentScreen.value)

        val list = project.taskList

        Text(list.toString())
    }
}
