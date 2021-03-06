package com.example.moneyco.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.moneyco.R

// Set of Material typography styles to start with

val Merienda = FontFamily(
    Font(R.font.merienda_regular),
    Font(R.font.merienda_bold, weight = FontWeight.Bold)
)

val Nunito = FontFamily(
    Font(R.font.nunito_regular),
    Font(R.font.nunito_bold, weight = FontWeight.Bold),
    Font(R.font.nunito_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.nunito_light, weight = FontWeight.Light),
    Font(R.font.nunito_medium, weight = FontWeight.Medium),
)


val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)