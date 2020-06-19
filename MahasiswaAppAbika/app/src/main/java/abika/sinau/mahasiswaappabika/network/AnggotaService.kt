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
        @Field("nama") nama: String,
        @Field("nim") nim: String,
        @Field("nohp") nohp: String,
        @Field("jurusan") jurusan: String,
        @Field("semester") semester: String,
        @Field("alamat") alamat: String
    ): Single<ResponseAnggotaAction>

    //Update Data
    @FormUrlEncoded
    @POST("updateData.php")
    fun updateData(
        @Field("id") id: String,
        @Field("nim") nim: String,
        @Field("nama") nama: String,
        @Field("nohp") nohp: String,
        @Field("jurusan") jurusan: String,
        @Field("semester") semester: String,
        @Field("alamat") alamat: String
    ): Single<ResponseAnggotaAction>

    @FormUrlEncoded
    @POST("deleteData.php")
    fun deleteData(
        @Field("id") id: String
    ): Single<ResponseAnggotaAction>
}