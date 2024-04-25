package Component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@Composable
fun TabScreen() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Dashboard", "Transaction", "Notification", "Account")
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title, fontSize = 12.sp) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    icon = {
                        when (index) {
                            0 -> Icon(imageVector = Icons.Default.Home, contentDescription = null)
                            1 -> Icon(imageVector = Icons.Default.Person, contentDescription = null)
                            2 -> Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = null
                            )
                            3 -> Icon(
                                imageVector = Icons.Default.AccountBox,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        }
        when (tabIndex) {
            0 -> {}
            1 -> {}
            2 -> {}
            3 -> {}
        }
    }
}