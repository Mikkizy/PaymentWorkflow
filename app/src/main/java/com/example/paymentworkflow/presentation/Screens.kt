package com.example.paymentworkflow.presentation

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home")
    object CardDetailsScreen: Screen("card_details")
    object CardPinScreen: Screen("card_pin")
    object SuccessScreen: Screen("payment_successful")
    object AccountDetailsScreen: Screen("account_details")
    object OtpScreen: Screen("otp")
}
