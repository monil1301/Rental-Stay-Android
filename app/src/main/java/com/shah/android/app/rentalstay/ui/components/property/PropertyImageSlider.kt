package com.shah.android.app.rentalstay.ui.components.property

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.ui.components.common.RS_Image
import com.shah.android.app.rentalstay.ui.theme.Dimen10

@Composable
fun PropertyImageSlider(modifier: Modifier = Modifier, images: List<String>) {
    LazyRow (
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Dimen10)
            ) {
        items(
            items = images
        ) { imageUrl ->
            RS_Image(
                Modifier.aspectRatio(1.2f),
                url = imageUrl,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Preview
@Composable
fun PreviewPropertyImageSlider() {
    PropertyImageSlider(
        images = listOf(
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",
            "https://res.cloudinary.com/stanza-living/image/upload/f_auto,q_auto,w_670/v1584975704/Website/CMS-Uploads/sjqjy5iq8ramxfqd8a4y.jpg",
            "https://cdn.pixabay.com/photo/2016/05/05/02/37/sunset-1373171__340.jpg",
            "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823__340.jpg"
        )
    )
}
