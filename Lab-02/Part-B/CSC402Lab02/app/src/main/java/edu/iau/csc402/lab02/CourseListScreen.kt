package edu.iau.csc402.lab02

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.csc402.lab02.ui.theme.AndroidGreen
import edu.iau.csc402.lab02.ui.theme.Navy
import edu.iau.csc402.lab02.ui.theme.ScreenBackground

data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

@Composable
fun CourseListScreen(modifier: Modifier = Modifier) {
    val courses = remember {
        listOf(
            Course("CSC 402", "Mobile Application Programming", 3, "Sun / Tue"),
            Course("CSC 311", "Database Systems", 3, "Sun / Tue"),
            Course("CSC 360", "Operating Systems", 3, "Mon / Wed"),
            Course("MATH 202", "Discrete Mathematics", 3, "Sun / Tue"),
            Course("ENG 234", "Technical Writing", 2, "Mon / Wed"),
            Course("PHYS 105", "General Physics II", 4, "Sun / Tue"),
            Course("ISLM 101", "Islamic Culture", 2, "Thu")
        )
    }

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
                text = "My Courses",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 10 - LazyColumn & data class",
                color = Color.White,
                fontSize = 13.sp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 0.dp, height = 4.dp)
                .background(AndroidGreen)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(courses) { course ->
                CourseRow(course)
            }
        }
    }
}

@Composable
fun CourseRow(course: Course) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .size(width = 5.dp, height = 64.dp)
                    .background(AndroidGreen)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = course.code,
                    color = Navy,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = course.title,
                    color = Navy,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = course.days,
                    color = Color.Gray,
                    fontSize = 11.sp
                )
            }

            Text(
                text = "${course.credits} cr",
                color = AndroidGreen,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(
                        color = Color(0xFFE0F7EA),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListScreen()
}

