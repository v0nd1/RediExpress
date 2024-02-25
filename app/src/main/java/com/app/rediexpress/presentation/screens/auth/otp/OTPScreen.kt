package com.app.rediexpress.presentation.screens.auth.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.rediexpress.presentation.components.ThemeButton
import com.app.rediexpress.ui.theme.Black
import com.app.rediexpress.ui.theme.Gray
import kotlinx.coroutines.delay

@Composable
@Preview(showBackground = true)
fun OTPScreen(
    //navController: NavController
){
    var value by remember {
        mutableStateOf("")
    }
    var second by remember {
        mutableIntStateOf(60)
    }
    val text =
        if (second > 0) "If you didn’t receive code, resend after $second"
        else "Отправить"
    LaunchedEffect(second){
        while (second > 0){
            delay(1000)
            second--
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ){

        Spacer(modifier = Modifier.weight(2f))
        Column(
            modifier = Modifier.weight(1.5f)
        ) {
            Text(
                text = "OTP Verification",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Enter the 6 digit numbers sent to your email",
                fontSize = 12.sp,
                color = Gray,
                fontWeight = FontWeight.SemiBold
            )
        }
        Column(
            modifier = Modifier.weight(1.5f)
        ) {
            CodeTextField(
                value = value,
                length = 6,
                onValueChange ={value = it}
                //navController = navController
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (second > 0){
                Text(
                    text = text,
                    color = Gray,
                    fontSize = 14.sp
                )
            }else{
                Text(
                    modifier = Modifier
                        .clickable { second = 60 },
                    text = "Отправить код",
                    color = Gray,
                    fontSize = 14.sp
                )
            }
        }
        Column(
            modifier = Modifier.weight(1.5f),
        ) {
            ThemeButton(
                label = "Log in",
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
        }
    }
}

@Composable
private fun CodeTextField(
    value: String,
    length: Int,
    modifier: Modifier = Modifier,
    boxWidth: Dp = 32.dp,
    boxHeight: Dp = 32.dp,
    enabled: Boolean = true,
    //spaceBetweenBoxes: Dp = 14.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit,
    //navController: NavController
) {
    BasicTextField(
        modifier = modifier,
        value = value,
        singleLine = true,
        onValueChange = {
            if (it.length <= length) {
                onValueChange(it)
            }
            if (it.length == 6 && it == "333333"){
                //navController.navigate(Screen.AddPassword.route)
            }
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        decorationBox = {
            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(length) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color.Transparent
                            )
                            .size(boxWidth, boxHeight)
                            .border(
                                1.dp,
                                color = Gray
                            ),

                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = value.getOrNull(it)?.toString() ?: "",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    )
}