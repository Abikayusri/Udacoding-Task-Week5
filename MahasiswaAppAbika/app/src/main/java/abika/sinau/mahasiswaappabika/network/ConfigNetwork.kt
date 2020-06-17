package abika.sinau.mahasiswaappabika.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Abika Chairul Yusri
 * on Wednesday, 17 June 2020
 * Bismillahirrahmanirrahim
 */
class ConfigNetwork {
    companion object {
        fun getNetwork(): UserService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.100.234/mentoring-kotlin-week5/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            val service = retrofit.create(UserService::class.java)

            return service
        }
    }
}