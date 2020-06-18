package abika.sinau.mahasiswaappabika.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Abika Chairul Yusri
 * on Thursday, 18 June 2020
 * Bismillahirrahmanirrahim
 */
data class ResponseAnggotaAction(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("isSuccess")
    val isSuccess: Boolean? = null
)