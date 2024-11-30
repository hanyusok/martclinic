package com.example.martclinic.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Clinic (
    val id: Int,
    @SerialName("created_at") val createdAt: String? = null,
    @SerialName("province")  val province: String? = null,
    @SerialName("city")    val city: String? = null,
    @SerialName("clinic_name")  val clinicName: String? = null,
    @SerialName("phone_number") val phoneNumber: String? = null,
    @SerialName("category") val category: String? = null,
    @SerialName("rat_available") val ratAvailable: Boolean? = null,
    @SerialName("address") val address: String? = null,
)