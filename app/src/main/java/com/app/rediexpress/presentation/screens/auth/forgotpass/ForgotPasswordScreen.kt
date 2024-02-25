package com.app.rediexpress.presentation.screens.auth.forgotpass

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.rediexpress.presentation.components.ThemeButton
import com.app.rediexpress.presentation.components.ThemeTextField
import com.app.rediexpress.presentation.navgraph.Screen
import com.app.rediexpress.ui.theme.Blue
import com.app.rediexpress.ui.theme.Gray


@Composable
fun ForgotPasswordScreen(
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Column(
            modifier = Modifier.weight(1.5f)
        ) {
            Text(
                text = "Forgot Password",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Enter your email address",
                fontSize = 12.sp,
                color = Gray,
                fontWeight = FontWeight.SemiBold
            )
        }
        Column(
            modifier = Modifier.weight(2f)
        ) {
            ThemeTextField(
                placeholder = "***********@mail.com",
                imeAction = ImeAction.Next,
                label = "Email Address"
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(2f)
        ) {
            ThemeButton(
                label = "Send OTP",
                onClick = {

                    navController.navigate(Screen.OTP.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(
                    text = "Remember password? Back to ",
                    color = Gray,
                    fontSize = 12.sp
                )
                Text(
                    text = "Sign in",
                    color = Blue,
                    fontSize = 12.sp,
                    modifier = Modifier.clickable {
                        navController.navigateUp()
                    }
                )
            }
        }

        Spacer(modifier = Modifier.weight(4.5f))
    }

}