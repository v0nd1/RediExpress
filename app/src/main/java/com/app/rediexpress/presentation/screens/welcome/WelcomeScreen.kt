package com.app.rediexpress.presentation.screens.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.app.rediexpress.presentation.components.ThemeButton
import com.app.rediexpress.presentation.navgraph.Screen
import com.app.rediexpress.ui.theme.Black
import com.app.rediexpress.ui.theme.Blue
import com.app.rediexpress.ui.theme.Gray
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(
    navController: NavController,
    onEvent: (WelcomeEvent) -> Unit
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
            if(pagerState.currentPage == 2){
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ThemeButton(
                        label = "Sign Up",
                        onClick = {
                            onEvent(WelcomeEvent.SaveAppEntry)
                            navController.popBackStack()
                            navController.navigate(Screen.AuthNavigation.route)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
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
                                navController.navigate(Screen.Login.route)
                            }
                        )
                    }
                }
            }else{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    val scope = rememberCoroutineScope()
                    ThemeButton(
                        label = "Skip",
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 2
                                )
                            }
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .height(50.dp),
                        border = BorderStroke(1.dp, Blue),
                        containerColor = Color.Transparent,
                        contentColor = Blue,
                        fontSize = 14.sp
                    )
                    ThemeButton(
                        label = "Next",
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .height(50.dp),
                        fontSize = 14.sp
                    )
                }
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