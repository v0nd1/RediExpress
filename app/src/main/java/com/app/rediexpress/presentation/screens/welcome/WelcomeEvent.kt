package com.app.rediexpress.presentation.screens.welcome

sealed class WelcomeEvent {
    data object SaveAppEntry: WelcomeEvent()
}