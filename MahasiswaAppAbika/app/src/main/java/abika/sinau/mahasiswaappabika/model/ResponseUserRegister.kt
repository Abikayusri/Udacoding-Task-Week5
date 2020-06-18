package abika.sinau.mahasiswaappabika.model

import com.google.gson.annotations.SerializedName

data class ResponseUserRegister(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)
