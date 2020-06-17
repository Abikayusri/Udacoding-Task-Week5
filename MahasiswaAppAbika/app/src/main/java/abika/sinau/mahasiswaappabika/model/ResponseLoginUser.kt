package abika.sinau.mahasiswaappabika.model

import com.google.gson.annotations.SerializedName

data class ResponseLoginUser(

    @field:SerializedName("data")
	val data: List<DataItemUser?>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)