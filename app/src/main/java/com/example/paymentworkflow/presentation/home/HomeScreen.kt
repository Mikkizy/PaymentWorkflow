package com.example.paymentworkflow.presentation.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.paymentworkflow.R
import com.example.paymentworkflow.common.Dimensions
import com.example.paymentworkflow.presentation.Screen
import com.example.paymentworkflow.ui.theme.PaymentWorkflowTheme

@Composable
fun HomeScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()
    val activity = (LocalContext.current as? Activity)
    BackHandler {
       activity?.finish()
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(
            backgroundColor = Color.White,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimensions.pagePadding.times(0.5f)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    modifier = Modifier.
                        size(Dimensions.mediumIcon),
                    imageVector = Icons.Default.Lock,
                    contentDescription = "lock"
                )
                Text(
                    text = stringResource(id = R.string.security),
                    style = MaterialTheme.typography.caption
                )
            }
        }}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(paddingValues)
                .padding(Dimensions.pagePadding)
        ) {
            Spacer(modifier = Modifier.height(Dimensions.threeSpacers))
            Spacer(modifier = Modifier.height(Dimensions.threeSpacers))
            Text(
                text = stringResource(id = R.string.payment_choice),
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.height(Dimensions.threeSpacers))
            Spacer(modifier = Modifier.height(Dimensions.threeSpacers))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.kinetic_color),
                    contentColor = Color.White
                ),
                onClick = { navController.navigate(Screen.CardDetailsScreen.route) }
            ) {
                Text(text = stringResource(id = R.string.card))
            }
            Spacer(modifier = Modifier.height(Dimensions.oneSpacer))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.kinetic_color),
                    contentColor = Color.White
                ),
                onClick = { navController.navigate(Screen.AccountDetailsScreen.route) }
            ) {
                Text(text = stringResource(id = R.string.account))
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PaymentWorkflowTheme {
        HomeScreen(navController = rememberNavController())
    }
}