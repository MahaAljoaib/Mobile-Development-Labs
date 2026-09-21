package edu.iau.cshj.csc402.lab3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.iau.cshj.csc402.lab3.ui.theme.CSC402_Lab3Theme

private val students = listOf(
    Student(
        name = "Maha AlJoaib",
        program = "Computer Science",
        gpa = "4.19",
        email = "maha@iau.edu.sa",
        city = "Khobar"
    ),
    Student(
        name = "Jana Alshammari",
        program = "Computer Science",
        gpa = "4.35",
        email = "jana@iau.edu.sa",
        city = "Dammam"
    ),
    Student(
        name = "Lara Alshamrani",
        program = "Computer Science",
        gpa = "4.28",
        email = "lara@iau.edu.sa",
        city = "Dhahran"
    ),
    Student(
        name = "Lina Alghamdi",
        program = "Computer Science",
        gpa = "4.42",
        email = "lina@iau.edu.sa",
        city = "Khobar"
    ),
    Student(
        name = "Reema Altuwajri",
        program = "Computer Science",
        gpa = "4.31",
        email = "reema@iau.edu.sa",
        city = "Dammam"
    )
)

@Composable
fun StudentsScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Students",
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = "${students.size} students",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        items(students) { student ->
            StudentCard(
                student = student
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StudentsScreenPreview() {
    CSC402_Lab3Theme {
        StudentsScreen()
    }
}

