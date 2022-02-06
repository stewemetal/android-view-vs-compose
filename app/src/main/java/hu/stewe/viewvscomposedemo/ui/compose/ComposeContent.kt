package hu.stewemetal.viewvscomposedemo.ui.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import hu.stewemetal.viewvscomposedemo.model.Item
import hu.stewemetal.viewvscomposedemo.ui.theme.ComposeDemoTheme

@Composable
fun ComposeContent() {
    ComposeDemoTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Compose implementation") },
                )
            },
            content = {
                LazyColumn {
                    items((1..30).toList()) {
                        ListItem(Item("Compose item $it"))
                    }
                }
            },
        )
    }
}