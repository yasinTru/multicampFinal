package com.yasin.multicampFinal.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Community(
    val name:String?,
    val description:String?,
    val banner:String?,
    val leader:leader?,
    val link:link?
):Parcelable

@Serializable
@Parcelize
data class leader(
    val name:String?,
    val photo:String?
):Parcelable

@Serializable
@Parcelize
data class link (
    val instagram:String?,
    val twitter:String?,
    val youtube:String?,
    val participation:String?
):Parcelable