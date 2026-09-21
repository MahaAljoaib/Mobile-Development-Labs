package edu.iau.cshj.csc402.lab3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.iau.cshj.csc402.lab3.ui.theme.CSC402_Lab3Theme

data class Student(
    val name: String,
    val program: String,
    val gpa: String,
    val email: String,
    val city: String
)

@Composable
fun StudentCard(
    student: Student,
    modifier: Modifier = Modifier
) {
    // Task 2 will fill this in
}

@Preview
@Composable
private fun StudentCardPreview() {
    CSC402_Lab3Theme {
        StudentCard(
            student = Student(
                name = "Maha AlJoaib",
                program = "Computer Science",
                gpa = "4.19",
                email = "maha@iau.edu.sa",
                city = "Khobar"
            )
        )
    }
}