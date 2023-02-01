package com.example.paymentworkflow.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.paymentworkflow.domain.model.Bank

@Composable
fun BankOptionsMenu(
    containerBackgroundColor: Color = MaterialTheme.colors.background,
    menuBackgroundColor: Color = MaterialTheme.colors.surface,
    menuContentColor: Color = MaterialTheme.colors.onSurface,
    options: List<Bank>,
    onOptionsMenuExpandChanges: () -> Unit,
    onMenuOptionSelected: (option: Bank) -> Unit,
    optionsMenuExpanded: Boolean,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        var bank by remember {
            mutableStateOf("Select Bank")
        }
        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            buttonColor = containerBackgroundColor,
            contentColor = MaterialTheme.colors.onBackground,
            text = bank,
        ) {
            onOptionsMenuExpandChanges()
        }
        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth()
                .background(menuBackgroundColor),
            expanded = optionsMenuExpanded,
            onDismissRequest = onOptionsMenuExpandChanges,
        ) {
            options.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(menuBackgroundColor)
                        .clickable {
                            onMenuOptionSelected(option)
                            bank = option.name
                        }
                        .padding(
                            horizontal = Dimensions.pagePadding,
                            vertical = 5.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(Dimensions.pagePadding.div(2)),
                ) {

                    Text(
                        text = option.name,
                        color = menuContentColor,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}