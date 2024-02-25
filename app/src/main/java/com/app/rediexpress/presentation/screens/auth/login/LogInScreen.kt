package com.app.rediexpress.presentation.screens.auth.login

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.rediexpress.R
import com.app.rediexpress.presentation.components.ThemeButton
import com.app.rediexpress.presentation.components.ThemeCheckBox
import com.app.rediexpress.presentation.components.ThemeTextField
import com.app.rediexpress.presentation.navgraph.Screen
import com.app.rediexpress.ui.theme.Blue
import com.app.rediexpress.ui.theme.Gray
import com.app.rediexpress.ui.theme.Orange


@Composable
fun LogInScreen(
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
                text = "Welcome Back",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Fill in your email and password to continue",
                fontSize = 12.sp,
                color = Gray,
                fontWeight = FontWeight.SemiBold
            )
        }

        ColumnFields(modifier = Modifier
            .fillMaxWidth()
            .weight(3f)
        )
        Elements(
            modifier = Modifier
                .weight(0.5f),
            navController = navController
        )
        Spacer(modifier = Modifier.weight(3f))
        Box(
            modifier = Modifier.weight(1.5f),
            contentAlignment = Alignment.Center,
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ThemeButton(
                    label = "Log in",
                    onClick = {
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(
                        text = "Already have an account?",
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
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "or sign in using",
                fontSize = 12.sp,
                color = Gray
            )
            Spacer(modifier = Modifier.height(5.dp))
            Icon(
                painter = painterResource(id = R.drawable.icon_google),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {  },
                tint = Orange
            )
        }
    }
}


@Composable
private fun ColumnFields(modifier: Modifier){
    Column(
        modifier = modifier
    ) {
        ThemeTextField(
            placeholder = "***********@mail.com",
            imeAction = ImeAction.Next,
            label = "Email Address"
        )
        Spacer(modifier = Modifier.height(14.dp))
        ThemeTextField(
            placeholder = "**********",
            imeAction = ImeAction.Next,
            label = "Password",
            keyboardType = KeyboardType.NumberPassword
        )
    }
}


@Composable
private fun Elements(modifier: Modifier, navController: NavController){
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                ThemeCheckBox()
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Remember password",
                    color = Gray,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
            Text(
                text = "Forgot Password?",
                color = Blue,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable{
                    navController.navigate(Screen.ForgotPassword.route)
                },
                fontSize = 12.sp
            )
        }
    }

}

