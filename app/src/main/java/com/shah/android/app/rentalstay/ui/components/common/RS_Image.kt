package com.shah.android.app.rentalstay.ui.components.common

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.shah.android.app.rentalstay.ui.theme.Silver
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun RS_Image(
    modifier: Modifier = Modifier,
    url: String?,
    shimmerParams: ShimmerParams = ShimmerParams(
        baseColor = MaterialTheme.colors.background,
        highlightColor = Silver
    ),
    contentScale: ContentScale = ContentScale.Fit,
    error: Any? = null,
) {
    GlideImage(
        modifier = modifier,
        imageModel = url ?: "",
        shimmerParams = shimmerParams,
        contentScale = contentScale,
        error = error,
    )
}
