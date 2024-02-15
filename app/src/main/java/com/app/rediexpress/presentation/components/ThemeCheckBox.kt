package com.app.rediexpress.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.rediexpress.ui.theme.BlueLight

@Composable
fun ThemeCheckBox(

){
    var check by remember {
        mutableStateOf(false)
    }
    Checkbox(
        checked = check,
        onCheckedChange = {check = it},
        colors = CheckboxDefaults.colors(
            checkedColor = BlueLight,
            uncheckedColor = BlueLight
        ),
        modifier = Modifier.size(20.dp)
    )
}