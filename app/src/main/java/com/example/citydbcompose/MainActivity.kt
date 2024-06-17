package com.example.citydbcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.citydbcompose.data.ConnectionStatus
import com.example.citydbcompose.data.currentConnectivityStatus
import com.example.citydbcompose.data.observeConnectivityasFlow
import com.example.citydbcompose.navigation.NavGraph
import com.example.citydbcompose.screens.MainScreen
import com.example.citydbcompose.screens.UnAvaliableScreen

    class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ЕСЛИ БЫ МЫ ДЕЛАЛИ ПО СОВЕСТИ И ВСЕ БЫ РАБОТАЛО В ПЛАНЕ API ТО ЗАХОДИМ В MyAPP
//            MyApp{
//                val navController = rememberNavController()
//                NavGraph(navController = navController)
//            }
            checkConnectivyStatus()
        }
    }
}

@Composable
fun checkConnectivyStatus(){

    val connection by connectivityStatus()

    val isConnected = connection === ConnectionStatus.Available

    if (isConnected) {
        MainScreen()
    }else{
        UnAvaliableScreen()
    }
}

@Composable
fun connectivityStatus(): State<ConnectionStatus>{
    val mCtx = LocalContext.current

    return produceState(initialValue = mCtx.currentConnectivityStatus) {
        mCtx.observeConnectivityasFlow().collect{value = it}
    }
}