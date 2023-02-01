package com.example.paymentworkflow.presentation.account

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.paymentworkflow.R
import com.example.paymentworkflow.common.Dimensions
import com.example.paymentworkflow.presentation.Screen

@Composable
fun OtpScreen(navController: NavController) {
    var otp by remember {
        mutableStateOf(TextFieldValue())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimensions.pagePadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(Dimensions.twoSpacers))
        Text(
            text = stringResource(id = R.string.otp_note),
            style = MaterialTheme.typography.caption
        )
        Spacer(modifier = Modifier.height(Dimensions.twoSpacers))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = otp,
            onValueChange = { otp = it },
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "otp")
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.code),
                    style = MaterialTheme.typography.caption
                )
            },
            label = {
                Text(
                    text = stringResource(id = R.string.otp),
                    style = MaterialTheme.typography.caption
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.height(Dimensions.twoSpacers))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.kinetic_color),
                contentColor = Color.White
            ),
            onClick = { navController.navigate(Screen.SuccessScreen.route) }
        ) {
            Text(text = stringResource(id = R.string.pay))
        }
    }
}