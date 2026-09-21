package edu.iau.cshj.csc402.lab3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF2F2F2)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = student.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF222222)
                    )

                    Text(
                        text = student.program,
                        fontSize = 14.sp,
                        color = Color(0xFF666666)
                    )
                }

                Text(
                    text = student.gpa,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF222222)
                )
            }

            HorizontalDivider(
                color = Color(0xFFD0D0D0)
            )

            Text(
                text = student.email,
                fontSize = 14.sp,
                color = Color(0xFF444444)
            )

            Text(
                text = student.city,
                fontSize = 14.sp,
                color = Color(0xFF444444)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StudentCardPreview() {
    CSC402_Lab3Theme {
        StudentCard(
            student = Student(
                name = "Maha AlJoaib",
                program = "Computer Science",
                gpa = "4.19",
                email = "2240006849@iau.edu.sa",
                city = "Khobar"
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}