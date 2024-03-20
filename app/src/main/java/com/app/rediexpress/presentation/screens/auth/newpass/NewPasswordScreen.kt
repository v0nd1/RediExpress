package com.app.rediexpress.presentation.screens.auth.newpass

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.rediexpress.presentation.components.ThemeButton
import com.app.rediexpress.presentation.components.ThemePasswordField
import com.app.rediexpress.presentation.navgraph.Screen
import com.app.rediexpress.ui.theme.Gray

@Composable
fun NewPasswordScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Column(
            modifier = Modifier.weight(1.5f)
        ) {
            Text(
                text = "New Password",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Enter new password",
                fontSize = 12.sp,
                color = Gray,
                fontWeight = FontWeight.SemiBold
            )
        }
        Column(
            modifier = Modifier.weight(4f)
        ) {
            ThemePasswordField(
                placeholder = "**********",
                imeAction = ImeAction.Next,
                label = "Password"
            )
            Spacer(modifier = Modifier.height(14.dp))
            ThemePasswordField(
                placeholder = "**********",
                imeAction = ImeAction.Done,
                label = "Confirm Password"
            )
        }
        Column(
            modifier = Modifier.weight(1.5f),
        ) {
            ThemeButton(
                label = "Log in",
                onClick = {
                    navController.navigate(Screen.MainNavigation.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
        }
        Spacer(modifier = Modifier.weight(3f))
    }
}