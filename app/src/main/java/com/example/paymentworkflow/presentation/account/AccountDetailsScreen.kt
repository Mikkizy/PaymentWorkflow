package com.example.paymentworkflow.presentation.account

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paymentworkflow.R
import com.example.paymentworkflow.common.BankOptionsMenu
import com.example.paymentworkflow.common.Dimensions
import com.example.paymentworkflow.common.InputItem
import com.example.paymentworkflow.domain.model.Bank
import com.example.paymentworkflow.presentation.Screen

@Composable
fun AccountDetailsScreen(navController: NavController) {

    var phoneNumber by remember {
        mutableStateOf(TextFieldValue())
    }
    var accountNumber by remember {
        mutableStateOf(TextFieldValue())
    }

    var menuExpanded by remember {
        mutableStateOf(false)
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
            text = stringResource(id = R.string.account_note),
            style = MaterialTheme.typography.caption.copy(fontSize = 20.sp)
        )
        Spacer(modifier = Modifier.height(Dimensions.oneSpacer))
        InputItem(
            modifier = Modifier.fillMaxWidth(),
            textFieldValue = phoneNumber,
            placeholder = "07776748xxx",
            label = "phone number",
            onTextChanged = {phoneNumber = it}
        )
        Spacer(modifier = Modifier.height(Dimensions.oneSpacer))
        InputItem(
            modifier = Modifier.fillMaxWidth(),
            textFieldValue = accountNumber,
            label = "account number",
            placeholder = "355xxxxxxxxxx",
            onTextChanged = {accountNumber = it}
        )
        Spacer(modifier = Modifier.height(Dimensions.oneSpacer))
        BankOptionsMenu(
            options = listOf(
                Bank("STANDARD CHARTERED"),
                Bank("STARLING BANK"),
                Bank("DEUTSCHE BANK"),
                Bank("ATOM BANK")
            ),
            onOptionsMenuExpandChanges = { menuExpanded = !menuExpanded },
            onMenuOptionSelected = {menuExpanded = !menuExpanded},
            optionsMenuExpanded = menuExpanded
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
            onClick = { navController.navigate(Screen.OtpScreen.route) }
        ) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}