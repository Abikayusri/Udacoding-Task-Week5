package abika.sinau.mahasiswaappabika.network

import abika.sinau.mahasiswaappabika.model.ResponseAnggotaAction
import abika.sinau.mahasiswaappabika.model.ResponseAnggotaData
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Abika Chairul Yusri
 * on Thursday, 18 June 2020
 * Bismillahirrahmanirrahim
 */
interface AnggotaService {

    //Get Data
    @GET("getData.php")
    fun getData(): Flowable<ResponseAnggotaData>

    //Insert Data
    @FormUrlEncoded
    @POST("insertData.php")
    fun insertData(
        @Field("mahasiswa_nim") nim: String,
        @Field("mahasiswa_nama") nama: String,
        @Field("mahasiswa_nohp") nohp: String,
        @Field("mahasiswa_jurusan") jurusan: String,
        @Field("mahasiswa_semester") semester: String,
        @Field("mahasiswa_alamat") alamat: String
    ): Single<ResponseAnggotaAction>

    //Update Data
    @FormUrlEncoded
    @POST("updateData.php")
    fun updateData(
        @Field("id_mahasiswa") id: String,
        @Field("mahasiswa_nim") nim: String,
        @Field("mahasiswa_nama") nama: String,
        @Field("mahasiswa_nohp") nohp: String,
        @Field("mahasiswa_jurusan") jurusan: String,
        @Field("mahasiswa_semester") semester: String,
        @Field("mahasiswa_alamat") alamat: String
    ): Single<ResponseAnggotaAction>

    @FormUrlEncoded
    @POST("deleteData.php")
    fun deleteData(
        @Field("id_mahasiswa") id: String
    ): Single<ResponseAnggotaAction>
}