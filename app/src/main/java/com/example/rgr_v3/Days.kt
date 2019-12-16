package com.example.rgr_v3
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Days(
    var les_1_chis: String? = "",
    var les_2_chis: String? = "",
    var les_3_chis: String? = "",
    var les_4_chis: String? = "",
    var les_1_znam: String? = "",
    var les_2_znam: String? = "",
    var les_3_znam: String? = "",
    var les_4_znam: String? = "",
    var note: String? = "")
