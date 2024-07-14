package com.check.ui.base.components.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.check.designsystem.theme.CustomTheme
import com.check.designsystem.theme.Shapes_MediumX

@Composable
fun TextInputField(
    text: String,
    label: String? = null,
    labelHeight: Dp = 5.dp,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth(),
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    textColor: Color = CustomTheme.colors.Black,
    disabledTextColor: Color = textColor.copy(ContentAlpha.disabled),
    backgroundColor: Color = Color.Transparent,
    borderFocusColor: Color = CustomTheme.colors.Black,
    borderUnFocusColor: Color = CustomTheme.colors.Black,
    textStyle: TextStyle = CustomTheme.typography.label_15_medium,
    placeHolderStyle: TextStyle = CustomTheme.typography.label_15_medium,
    placeholderColor: Color = CustomTheme.colors.Black,
    labelColor: Color = textColor,
    cursorColor: Color = textColor,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    singleLine: Boolean = true,
    isEnabled: Boolean = true,
    isReadOnly: Boolean = false,
) {

    Column {
        label?.let {
            Text(text = label, color = labelColor)
            Spacer(modifier = Modifier.height(labelHeight))
        }
        OutlinedTextField(
            value = text,
            textStyle = textStyle,
            placeholder = {
                Text(
                    placeholder,
                    style = placeHolderStyle,
                    color = placeholderColor
                )
            },
            onValueChange = onValueChange,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            isError = isError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = textColor,
                disabledTextColor = disabledTextColor,
                focusedBorderColor = borderFocusColor,
                unfocusedBorderColor = borderUnFocusColor,
                backgroundColor = backgroundColor,
                placeholderColor = placeholderColor,
                unfocusedLabelColor = placeholderColor,
                cursorColor = cursorColor
            ),
            shape = Shapes_MediumX,
            readOnly = isReadOnly,
            enabled = isEnabled,
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon
        )
    }
}
