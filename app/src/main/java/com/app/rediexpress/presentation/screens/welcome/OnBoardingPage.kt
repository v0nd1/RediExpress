package com.app.rediexpress.presentation.screens.welcome

import androidx.annotation.DrawableRes
import com.app.rediexpress.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    data object First : OnBoardingPage(
        image = R.drawable.image_1,
        title = "Quick Delivery At Your Doorstep",
        description = "Enjoy quick pick-up and delivery to your destination"
    )
    data object Second : OnBoardingPage(
        image = R.drawable.image_2,
        title = "Flexible Payment",
        description = "Different modes of payment either before and after delivery without stress"
    )
    data object Third : OnBoardingPage(
        image = R.drawable.image_3,
        title = "Real-time Tracking",
        description = "Track your packages/items from the comfort of your home till final destination"
    )

}