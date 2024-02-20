package com.app.rediexpress.presentation.screens.signup

import android.widget.Space
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.rediexpress.R
import com.app.rediexpress.navigation.Screen
import com.app.rediexpress.presentation.components.ThemeButton
import com.app.rediexpress.presentation.components.ThemeCheckBox
import com.app.rediexpress.presentation.components.ThemeTextField
import com.app.rediexpress.ui.theme.Blue
import com.app.rediexpress.ui.theme.BlueLight
import com.app.rediexpress.ui.theme.Gray
import com.app.rediexpress.ui.theme.Orange

@Composable
fun SignUpScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.weight(0.5f))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Create an account",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Complete the sign up process to get started",
                fontSize = 12.sp,
                color = Gray,
                fontWeight = FontWeight.SemiBold
            )
        }

        ColumnOfTextFields(modifier = Modifier.weight(6f))
        RowPrivacy(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier.weight(1.5f),
            contentAlignment = Alignment.Center,
        ){
            val annotatedText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Gray,
                        fontSize = 12.sp,
                    )
                ){
                    append("Already have an account? ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Blue,
                        fontSize = 12.sp,
                    )
                ){
                    append("Sign in")
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ThemeButton(
                    label = "Sign Up",
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Screen.LogIn.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                ClickableText(
                    text = annotatedText,
                    onClick = {
                        annotatedText.getStringAnnotations(
                            tag = "Sign in",
                            start = it,
                            end = it
                        )[0].let {
                            // Navigate to login
                        }
                    }
                )

            }
        }
        Column(
            modifier = Modifier
                .weight(1.5f)
                .fillMaxWidth(),
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
                modifier = Modifier.size(20.dp),
                tint = Orange
            )
        }


    }
}

@Composable
private fun RowPrivacy(modifier: Modifier){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            ThemeCheckBox()
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "By ticking this box, you agree to our Terms and conditions and private policy",
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                lineHeight = 13.sp,
                modifier = Modifier.wrapContentSize()
            )
        }
    }

}

@Composable
private fun ColumnOfTextFields(modifier: Modifier){
    Column(
        modifier = modifier
    ) {
        ThemeTextField(
            placeholder = "Ivanov Ivan",
            imeAction = ImeAction.Next,
            label = "Full name"
        )
        Spacer(modifier = Modifier.height(14.dp))
        ThemeTextField(
            placeholder = "+7(999)999-99-99",
            imeAction = ImeAction.Next,
            label = "Phone Number",
            keyboardType = KeyboardType.NumberPassword
        )
        Spacer(modifier = Modifier.height(14.dp))
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
        Spacer(modifier = Modifier.height(14.dp))
        ThemeTextField(
            placeholder = "**********",
            imeAction = ImeAction.Done,
            label = "Confirm Password",
            keyboardType = KeyboardType.NumberPassword
        )
    }

}

