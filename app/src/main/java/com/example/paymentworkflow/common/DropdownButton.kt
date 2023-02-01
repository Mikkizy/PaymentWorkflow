package com.example.paymentworkflow.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevationEnabled: Boolean = true,
    buttonColor: Color,
    contentColor: Color,
    isLoading: Boolean = false,
    padding: PaddingValues = PaddingValues(vertical = 10.dp, horizontal = 10.dp),
    shape: Shape = MaterialTheme.shapes.medium,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.button,
    leadingIcon: @Composable () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {},
    onButtonClicked: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = {
            onButtonClicked()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonColor,
            contentColor = contentColor,
            disabledBackgroundColor = buttonColor.copy(alpha = 0.7f),
            disabledContentColor = contentColor.copy(alpha = 0.7f),
        ),
        enabled = enabled,
        shape = shape,
        contentPadding = padding,
        elevation = if (elevationEnabled) ButtonDefaults.elevation()
        else ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = Dimensions.elevation
        ),
    ) {
        leadingIcon()
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(end = Dimensions.pagePadding)
                    .size(Dimensions.mediumIcon),
                color = MaterialTheme.colors.onPrimary,
                strokeWidth = 5.dp
            )
        } else {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                style = textStyle,
                color = contentColor,
            )
        }
        trailingIcon()
    }
}