package com.example.paymentworkflow.presentation.successful

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.paymentworkflow.R
import com.example.paymentworkflow.common.Dimensions
import com.example.paymentworkflow.presentation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PaymentSuccessfulScreen(navController: NavController) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimensions.pagePadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.successful),
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.width(Dimensions.threeSpacers))
        Spacer(modifier = Modifier.width(Dimensions.twoSpacers))
        Image(
            modifier = Modifier
                .size(200.dp),
            painter = painterResource(id = R.drawable.ic_thumbs_up),
            contentDescription = "payment successful"
        )
        Spacer(modifier = Modifier.width(Dimensions.threeSpacers))
        Spacer(modifier = Modifier.width(Dimensions.twoSpacers))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.kinetic_color),
                contentColor = Color.White
            ),
            onClick = { scope.launch {
                Toast.makeText(context, "Receipt has been saved!", Toast.LENGTH_SHORT).show()
                delay(2000L)
                navController.navigate(Screen.HomeScreen.route) {
                    popUpTo(Screen.SuccessScreen.route) {
                        inclusive = true
                    }
                }
            } }
        ) {
            Text(text = stringResource(id = R.string.receipt))
        }
    }
    
}