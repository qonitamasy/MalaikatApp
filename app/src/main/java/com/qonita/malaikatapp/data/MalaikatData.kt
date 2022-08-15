package com.qonita.malaikatapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MalaikatData (
    var name: String = "",
    var duty: String = "",
    var detail: String = "",
    var photo: Int = 0,
): Parcelable