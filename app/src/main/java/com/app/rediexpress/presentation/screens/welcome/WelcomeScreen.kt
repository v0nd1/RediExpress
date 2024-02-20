package com.app.rediexpress.presentation.screens.welcome

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.app.rediexpress.R
import com.app.rediexpress.navigation.Screen
import com.app.rediexpress.presentation.components.ThemeButton
import com.app.rediexpress.presentation.components.ThemeOutlinedButton
import com.app.rediexpress.ui.theme.Black
import com.app.rediexpress.ui.theme.Blue
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(
    navController: NavHostController
){
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState(
        pageCount = {
            3
        }
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(10f)
        ) {
            PagerScreen(onBoardingPage = pages[it])
        }
        Box(modifier = Modifier.weight(2f)){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                ThemeOutlinedButton(
                    label = "Skip",
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Screen.Home.route)
                    }
                )
                FinishButton(
                    pagerState = pagerState,
                    navController = navController
                )
            }
        }

    }
}
@Composable
private fun PagerScreen(onBoardingPage: OnBoardingPage){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.5f)
                .weight(8f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Image"
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 50.dp)
                .weight(4f)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = onBoardingPage.title,
                fontSize = 22.sp,
                color = Blue,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = onBoardingPage.description,
                fontSize = 14.sp,
                color = Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal
            )
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun FinishButton(pagerState: PagerState, navController: NavController){
    val scope = rememberCoroutineScope()
    ThemeButton(
        label = "Next",
        onClick = {
            scope.launch {
                if (pagerState.currentPage == 2){
                    navController.popBackStack()
                    navController.navigate(Screen.Home.route)
                }else{
                    pagerState.animateScrollToPage(
                        page = pagerState.currentPage + 1
                    )
                }
            }
        }
    )
}