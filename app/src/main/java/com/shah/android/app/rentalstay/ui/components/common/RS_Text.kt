package com.shah.android.app.rentalstay.ui.components.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.ui.theme.*
import com.shah.android.app.rentalstay.utilities.enums.ViewPosition

@Composable
fun RS_Text(
    modifier: Modifier = Modifier,
    text: String,
    fontFamily: FontFamily = Lato,
    fontSize: TextUnit = TextSize14,
    lineHeight: TextUnit = TextSize21,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign? = null,
    color: Color = Color.Black,
    drawablePosition: ViewPosition = ViewPosition.START,
    @DrawableRes drawableResource: Int? = null,
    drawableDescription: String? = null,
    drawablePadding: Dp = Dimen0,
    drawableSize: Dp = Dimen20,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (drawableResource != null && drawablePosition == ViewPosition.START) {
            DrawableView(drawablePadding,
                drawableSize,
                drawableResource,
                drawableDescription,
                drawablePosition,
                color
            )
        }
        Text(
            text = text,
            fontFamily = fontFamily,
            fontSize = fontSize,
            lineHeight = lineHeight,
            fontWeight = fontWeight,
            textAlign = textAlign,
            color = color
        )
        if (drawableResource != null && drawablePosition == ViewPosition.END) {
            DrawableView(drawablePadding,
                drawableSize,
                drawableResource,
                drawableDescription,
                drawablePosition,
                color
            )
        }
    }
}

@Preview
@Composable
fun PreviewVV_Text() {
    RS_Text(text = stringResource(id = R.string.app_name))
}
