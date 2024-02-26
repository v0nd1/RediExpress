package com.app.rediexpress.presentation.components

import android.graphics.fonts.Font
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ChipBorder
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.rediexpress.ui.theme.Blue
import com.app.rediexpress.ui.theme.White

@Composable
fun ThemeButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier,
    containerColor: Color = Blue,
    contentColor: Color = White,
    border: BorderStroke ?= null,
    fontSize: TextUnit = 16.sp
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        modifier = modifier,
        shape = RoundedCornerShape(10),
        border = border

    ) {
        Text(
            text = label,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
        
    }
}