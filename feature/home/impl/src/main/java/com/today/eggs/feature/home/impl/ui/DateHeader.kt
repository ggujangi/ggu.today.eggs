package com.today.eggs.feature.home.impl.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.datetime.LocalDate

@Composable
fun DateHeader(
    date: LocalDate,
    modifier: Modifier = Modifier
) {
    val dateString = "${date.year}.${date.monthNumber}.${date.dayOfMonth}"

    Text(
        text = dateString,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center,
        maxLines = 1,
    )
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Date Header"
)
fun DateHeaderPreview() {
    DateHeader(
        date = LocalDate(2023, 12, 1),
        modifier = Modifier.fillMaxWidth()
    )
}