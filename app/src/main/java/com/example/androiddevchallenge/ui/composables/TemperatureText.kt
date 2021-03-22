package com.example.androiddevchallenge.ui.composables

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

@Composable
fun TemperatureText(
    temperature: String,
    style: TextStyle = LocalTextStyle.current,
    color: Color = Color.Unspecified
) {
    Text(
        buildAnnotatedString {
            append(temperature)
            withStyle(style.toSpanStyle().copy(fontSize = style.fontSize * 0.8)) { append("°C") }
        },
        style = style,
        color = color
    )
}
