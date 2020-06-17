package abika.sinau.mahasiswaappabika.network

import abika.sinau.mahasiswaappabika.model.ResponseLoginUser
import abika.sinau.mahasiswaappabika.model.ResponseRegisterUser
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Abika Chairul Yusri
 * on Wednesday, 17 June 2020
 * Bismillahirrahmanirrahim
 */
interface UserService {
    // implement reactive programming
    @FormUrlEncoded
    @POST("userRegister.php")
    fun register(
        @Field("nama") nama: String,
        @Field("nama") email: String,
        @Field("nama") password: String
    ):Single<ResponseRegisterUser>

    @FormUrlEncoded
    @POST("userLogin.php")
    fun login(
        @Field("nama") email: String,
        @Field("nama") password: String
    ):Flowable<ResponseLoginUser>
}