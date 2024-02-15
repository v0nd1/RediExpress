package com.app.rediexpress.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ThemeButton(
    label: String
){
    Button(
        onClick = { /*TODO*/ }
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.SemiBold
        )
        
    }
}