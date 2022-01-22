package com.shah.android.app.rentalstay.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.ui.theme.*
import com.shah.android.app.rentalstay.utilities.enums.ViewPosition

@Composable
fun RS_TextFieldWithIcon(
    modifier: Modifier,
    @DrawableRes icon: Int,
    iconDescription: String,
    label: String,
    singleLine: Boolean = false,
    maxCharacterLength: Int? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChanged: (String?) -> Unit,
) {
    var textValue by remember { mutableStateOf("") }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(Dimen12),
        color = MaterialTheme.colors.surface
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
                drawablePosition = ViewPosition.START
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(vertical = Dimen10),
                value = "",
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
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
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