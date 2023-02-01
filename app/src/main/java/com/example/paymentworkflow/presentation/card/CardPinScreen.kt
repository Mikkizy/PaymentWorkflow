package com.example.paymentworkflow.presentation.card

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.paymentworkflow.R
import com.example.paymentworkflow.common.Dimensions
import com.example.paymentworkflow.presentation.Screen

@Composable
fun CardPinScreen(navController: NavController) {

    var cardPin by remember {
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
            text = stringResource(id = R.string.card_pin_note),
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.height(Dimensions.twoSpacers))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = cardPin,
            onValueChange = { cardPin = it },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "pin")
            },
            label = {
                Text(
                    text = stringResource(id = R.string.pin),
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