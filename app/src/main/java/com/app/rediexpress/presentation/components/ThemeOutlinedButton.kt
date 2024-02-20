package com.app.rediexpress.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.rediexpress.ui.theme.Blue

@Composable
fun ThemeOutlinedButton(
    label: String,
    onClick: () -> Unit,
    width: Dp = 100.dp,
    height: Dp = 50.dp
){
    Button(
        onClick = onClick,
        border = BorderStroke(1.dp, Blue),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Blue
        ),
        modifier = Modifier
            .width(width)
            .height(height),
        shape = RoundedCornerShape(15)
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

    }
}