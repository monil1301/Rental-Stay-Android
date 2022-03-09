package com.shah.android.app.rentalstay.ui.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.shah.android.app.rentalstay.ui.theme.Dimen0
import com.shah.android.app.rentalstay.utilities.enums.ViewPosition

@Composable
fun DrawableView(
    drawablePadding: Dp,
    drawableSize: Dp,
    drawableResource: Int,
    drawableDescription: String?,
    drawablePosition: ViewPosition,
    tint: Color
) {
    Icon(
        modifier = Modifier
            .padding(end = if (drawablePosition == ViewPosition.START) drawablePadding else Dimen0)
            .padding(start = if (drawablePosition == ViewPosition.END) drawablePadding else Dimen0)
            .size(drawableSize),
        painter = painterResource(id = drawableResource),
        contentDescription = drawableDescription,
        tint = tint
    )
}
