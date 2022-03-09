package com.shah.android.app.rentalstay.ui.components.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.ui.theme.*
import com.shah.android.app.rentalstay.utilities.enums.ViewPosition

@Composable
fun RS_Button(
    modifier: Modifier,
    title: String,
    textColor: Color = MaterialTheme.colors.onPrimary,
    backgroundColor: Color = MaterialTheme.colors.primary,
    shape: Shape = RoundedCornerShape(30.dp),
    textSize: TextUnit = 14.sp,
    fontFamily: FontFamily = Lato,
    fontWeight: FontWeight = FontWeight.Bold,
    drawablePosition: ViewPosition = ViewPosition.START,
    @DrawableRes drawableResource: Int? = null,
    drawableDescription: String? = null,
    drawablePadding: Dp = Dimen0,
    drawableSize: Dp = Dimen20,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    borderStroke: BorderStroke? = null,
    isEnabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = shape,
        border = borderStroke,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            disabledBackgroundColor = Color.Gray
        ),
        onClick = { onClick() },
        contentPadding = contentPadding,
        elevation = elevation,
    ) {

        if (drawableResource != null && drawablePosition == ViewPosition.START) {
            DrawableView(
                drawablePadding,
                drawableSize,
                drawableResource,
                drawableDescription,
                drawablePosition,
                textColor
            )
        }

        RS_Text(
            text = title,
            fontSize = textSize,
            color = textColor,
            fontWeight = fontWeight,
            fontFamily = fontFamily
        )

        if (drawableResource != null && drawablePosition == ViewPosition.END) {
            DrawableView(
                drawablePadding,
                drawableSize,
                drawableResource,
                drawableDescription,
                drawablePosition,
                textColor
            )
        }
    }
}

@Preview
@Composable
fun PreviewButton() {
    RS_Button(
        modifier = Modifier,
        title = stringResource(id = R.string.app_name),
        drawableResource = R.drawable.ic_launcher_foreground,
        drawablePadding = Dimen10,
        drawableSize = Dimen30
    ) {}
}
