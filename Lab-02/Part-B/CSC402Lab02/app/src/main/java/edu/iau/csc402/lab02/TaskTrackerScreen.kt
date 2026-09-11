package edu.iau.csc402.lab02

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.csc402.lab02.ui.theme.AndroidGreen
import edu.iau.csc402.lab02.ui.theme.Navy
import edu.iau.csc402.lab02.ui.theme.ScreenBackground

data class TeamTask(
    val id: Int,
    val title: String,
    val owner: String,
    val isDone: Boolean = false
)

@Composable
fun TaskTrackerScreen(modifier: Modifier = Modifier) {
    val tasks = remember {
        mutableStateListOf(
            TeamTask(1, "Create GitHub repository", "Maha", true),
            TeamTask(2, "Write project report", "Maha", true),
            TeamTask(3, "Design the login screen", "Maha"),
            TeamTask(4, "Set up Android Studio", "Maha")
        )
    }

    val doneCount = tasks.count { it.isDone }
    val openCount = tasks.size - doneCount

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Team Task Tracker",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 11 - Challenge",
                color = Color.White,
                fontSize = 13.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Navy)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SummaryItem("Total", tasks.size.toString())
            SummaryItem("Open", openCount.toString())
            SummaryItem("Done", doneCount.toString())
        }

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(
                items = tasks,
                key = { it.id }
            ) { task ->
                TaskRow(
                    task = task,
                    onToggle = {
                        val index = tasks.indexOfFirst { it.id == task.id }
                        tasks[index] = task.copy(isDone = !task.isDone)
                    }
                )
            }
        }

        Button(
            onClick = {
                val nextId = (tasks.maxOfOrNull { it.id } ?: 0) + 1
                tasks.add(
                    TeamTask(
                        id = nextId,
                        title = "New task",
                        owner = "Maha"
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text("+ Add task")
        }
    }
}

@Composable
fun SummaryItem(
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = label,
            color = Color.White,
            fontSize = 12.sp
        )
    }
}

@Composable
fun TaskRow(
    task: TeamTask,
    onToggle: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isDone,
                onCheckedChange = { onToggle() }
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = task.title,
                    color = Navy,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (task.isDone) {
                        androidx.compose.ui.text.style.TextDecoration.LineThrough
                    } else {
                        androidx.compose.ui.text.style.TextDecoration.None
                    }
                )

                Text(
                    text = task.owner,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskTrackerScreenPreview() {
    TaskTrackerScreen()
}