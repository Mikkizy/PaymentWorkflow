package com.example.paymentworkflow.presentation.card

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.paymentworkflow.R
import com.example.paymentworkflow.common.CreditCardFilter
import com.example.paymentworkflow.common.InputItem
import com.example.paymentworkflow.presentation.Screen

@ExperimentalAnimationApi
@Composable
fun CardDetailsScreen(navController: NavController) {
    var nameText by remember { mutableStateOf(TextFieldValue()) }
    var cardNumber by remember { mutableStateOf(TextFieldValue()) }
    var expiryNumber by remember { mutableStateOf(TextFieldValue()) }
    var cvcNumber by remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.fillMaxSize()) {
        PaymentCard(
            nameText,
            cardNumber,
            expiryNumber,
            cvcNumber
        )
        LazyColumn(
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        ) {
            item {
                InputItem(
                    textFieldValue = nameText,
                    label = stringResource(id = R.string.card_holder_name),
                    onTextChanged = { nameText = it },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                )
            }

            item {
                InputItem(
                    textFieldValue = cardNumber,
                    label = stringResource(id = R.string.card_holder_number),
                    keyboardType = KeyboardType.Number,
                    onTextChanged = { cardNumber = it },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    visualTransformation = CreditCardFilter
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    InputItem(
                        textFieldValue = expiryNumber,
                        label = stringResource(id = R.string.exipry_date),
                        keyboardType = KeyboardType.Number,
                        onTextChanged = { expiryNumber = it },
                        modifier = Modifier.weight(1f)
                            .padding(end = 8.dp)
                    )
                    InputItem(
                        textFieldValue = cvcNumber,
                        label = stringResource(id = R.string.cvc),
                        keyboardType = KeyboardType.Number,
                        onTextChanged = { cvcNumber = it },
                        modifier = Modifier.weight(1f)
                            .padding(start = 8.dp)
                    )
                }
            }

            item {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.kinetic_color),
                        contentColor = Color.White
                    ),
                    onClick = {navController.navigate(Screen.CardPinScreen.route) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.enter),
                        modifier = Modifier.padding(horizontal = 30.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}
