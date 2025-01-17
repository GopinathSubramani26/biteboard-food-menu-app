package com.app.ui.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.ui.theme.Grey300
import com.app.ui.theme.textHint

@Composable
fun BiteBoardTextField(
    modifier: Modifier = Modifier,
    textValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    prefix: String? = null,
    placeholder: String,
    label: String? = null,
    errorText: String,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium.copy(color = Black),
    placeholderTextStyle: TextStyle = MaterialTheme.typography.bodyMedium.copy(color = textHint),
    textColor: Color = Black,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    imeAction: ImeAction = ImeAction.Next,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.Words,
    isError: Boolean = false,
    isEnable: Boolean = true,
    errorTextAlign: TextAlign = TextAlign.Start,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,

    ) {
        var isFocused by remember {
            mutableStateOf(false)
        }


        OutlinedTextField(
            value = textValue,
            onValueChange = { newText ->
                onValueChange.invoke(newText)
            },
            modifier = modifier
                .onFocusChanged {
                    isFocused = it.isFocused
                },
            placeholder = {
                if (placeholder.isNotBlank() && label == null) {
                    Text(
                        text = placeholder, style = placeholderTextStyle,
                        color = textHint
                    )
                }
            },
            label = {
                if (label?.isNotBlank() == true) {
                    Text(
                        text = label,
                        style = if (textValue.text.isBlank() && !isFocused)
                            placeholderTextStyle
                        else MaterialTheme.typography.displaySmall.copy(
                            color = if (isError) MaterialTheme.colorScheme.error else if (isFocused) textColor else Grey300,
                            fontSize = 12.sp
                        )
                    )
                }
            },
            prefix = { prefix?.let { Text(prefix) } },
            enabled = isEnable,
            singleLine = true,
            textStyle = textStyle,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = textColor,
                unfocusedContainerColor = Color.Transparent,
                unfocusedTextColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                cursorColor = textColor,
                errorTextColor = MaterialTheme.colorScheme.error,
                errorBorderColor = MaterialTheme.colorScheme.error,
                focusedBorderColor = Black,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline),

            supportingText = {

                if (isError) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp),
                        text = errorText,
                        style = MaterialTheme.typography.displaySmall.copy(
                            color = MaterialTheme.colorScheme.error,
                            textAlign = errorTextAlign
                        ),
                    )
                }

            },
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardActions = keyboardActions,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = imeAction,
                keyboardType = keyboardType,
                capitalization = capitalization
            ),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
        )
    }