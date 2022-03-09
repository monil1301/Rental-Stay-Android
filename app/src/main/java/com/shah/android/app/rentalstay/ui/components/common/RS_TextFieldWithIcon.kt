package com.shah.android.app.rentalstay.ui.components.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.ui.theme.*
import com.shah.android.app.rentalstay.utilities.enums.ViewPosition

/**
 * Text field with label and leading icon
 *
 * @param modifier Modification foe the view
 * @param icon Drawable resource Id
 * @param iconDescription Description text for icon
 * @param label Label to be displayed for text field
 * @param singleLine When set to true, this text field becomes a single horizontally scrolling text field instead of wrapping onto multiple lines
 * @param maxCharacterLength Maximum allowed character input length
 * @param keyboardType Type of keyboard to be displayed for input like numerical
 * @param onValueChanged Callback for updating the new value of the text field after user interaction
 */
@Composable
fun RS_TextFieldWithIcon(
    modifier: Modifier,
    @DrawableRes icon: Int,
    iconDescription: String,
    label: String,
    elevation: Dp = Dimen10,
    singleLine: Boolean = false,
    maxCharacterLength: Int? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    text: String = "",
    onValueChanged: (String) -> Unit,
) {
    var textValue by remember { mutableStateOf(text) }
    var passwordVisibility by remember { mutableStateOf(keyboardType != KeyboardType.Password ) }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(Dimen12),
        color = MaterialTheme.colors.surface,
        elevation = elevation
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = Dimen12),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DrawableView(
                drawablePadding = Dimen0,
                drawableSize = Dimen24,
                drawableResource = icon,
                drawableDescription = iconDescription,
                drawablePosition = ViewPosition.START,
                Color.DarkGray
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(vertical = Dimen4)
                    .fillMaxWidth(),
                value = textValue,
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                singleLine = singleLine,
                onValueChange = { newValue ->
                    textValue = if (maxCharacterLength != null) {
                        newValue.take(maxCharacterLength)
                    } else {
                        newValue
                    }
                    onValueChanged(textValue)
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                textStyle = TextStyle(
                    color = MaterialTheme.colors.onSurface
                ),
                label = {
                    Text(
                        text = label,
                        fontFamily = Lato,
                        lineHeight = TextSize12,
                        color = DarkGray
                    )
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = if (keyboardType == KeyboardType.Password) {
                    {
                        val image = if (passwordVisibility)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            Icon(imageVector = image, iconDescription)
                        }
                    }
                } else null
            )
        }
    }
}

@Preview
@Composable
fun PreviewRS_CardTextField() {
    RS_TextFieldWithIcon(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = Dimen10),
        icon = R.drawable.icon_profile,
        iconDescription = "",
        label = "Name"
    ) {}
}
