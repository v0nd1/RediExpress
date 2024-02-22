package com.app.rediexpress.presentation.mainActivity

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.rediexpress.domain.usecases.AppEntryUseCases
import com.app.rediexpress.presentation.navgraph.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

    private val _splashCondition = mutableStateOf(true)
    val splashCondition: State<Boolean> = _splashCondition

    private val _startDestination = mutableStateOf(Screen.AppStartNavigation.route)
    val startDestination: State<String> = _startDestination

    init {
        appEntryUseCases.readAppEntry().onEach {
            if(it){
                _startDestination.value = Screen.AuthNavigation.route
            }else{
                _startDestination.value = Screen.AppStartNavigation.route
            }
            delay(200) // Without this delay, the onBoarding screen will show for a momentum.
            _splashCondition.value = false
        }.launchIn(viewModelScope)
    }
}