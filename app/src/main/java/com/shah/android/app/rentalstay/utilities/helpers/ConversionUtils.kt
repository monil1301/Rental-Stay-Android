package com.shah.android.app.rentalstay.utilities.helpers

import java.text.DecimalFormat

fun Int.toRupees(): String {
    val formatter = DecimalFormat("##,##,###")
    return formatter.format(this)
}
