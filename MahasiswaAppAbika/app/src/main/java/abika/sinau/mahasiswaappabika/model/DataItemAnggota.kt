package abika.sinau.mahasiswaappabika.model

import com.google.gson.annotations.SerializedName

data class DataItemAnggota(

	@field:SerializedName("mahasiswa_alamat")
	val mahasiswaAlamat: String? = null,

	@field:SerializedName("mahasiswa_nohp")
	val mahasiswaNohp: String? = null,

	@field:SerializedName("mahasiswa_jurusan")
	val mahasiswaJurusan: String? = null,

	@field:SerializedName("id_mahasiswa")
	val idMahasiswa: String? = null,

	@field:SerializedName("mahasiswa_nama")
	val mahasiswaNama: String? = null,

	@field:SerializedName("mahasiswa_nik")
	val mahasiswaNik: String? = null,

	@field:SerializedName("mahasiswa_semester")
	val mahasiswaSemester: String? = null
)