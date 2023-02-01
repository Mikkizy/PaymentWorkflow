package com.example.paymentworkflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.paymentworkflow.presentation.Screen
import com.example.paymentworkflow.presentation.account.AccountDetailsScreen
import com.example.paymentworkflow.presentation.account.OtpScreen
import com.example.paymentworkflow.presentation.card.CardDetailsScreen
import com.example.paymentworkflow.presentation.card.CardPinScreen
import com.example.paymentworkflow.presentation.home.HomeScreen
import com.example.paymentworkflow.presentation.successful.PaymentSuccessfulScreen
import com.example.paymentworkflow.ui.theme.PaymentWorkflowTheme

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaymentWorkflowTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.HomeScreen.route
                ){
                    composable(Screen.HomeScreen.route) {
                        HomeScreen(navController = navController)
                    }
                    composable(Screen.CardDetailsScreen.route) {
                        CardDetailsScreen(navController = navController)
                    }
                    composable(Screen.CardPinScreen.route) {
                        CardPinScreen(navController = navController)
                    }
                    composable(Screen.SuccessScreen.route) {
                        PaymentSuccessfulScreen(navController = navController)
                    }
                    composable(Screen.AccountDetailsScreen.route) {
                        AccountDetailsScreen(navController = navController)
                    }
                    composable(Screen.OtpScreen.route) {
                        OtpScreen(navController = navController)
                    }
                }
            }
        }
    }
}