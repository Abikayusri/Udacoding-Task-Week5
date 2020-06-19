package abika.sinau.mahasiswaappabika.ui.main

import abika.sinau.mahasiswaappabika.network.ConfigNetwork
import android.widget.Toast
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Abika Chairul Yusri
 * on Thursday, 18 June 2020
 * Bismillahirrahmanirrahim
 */
class MainPresenter(val mahasiswa: MainView) {
    fun getMahasiswa() {
        mahasiswa.startProgressBar()
        ConfigNetwork.anggotaService().getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.isSuccess != false) {
                    mahasiswa.hideProgressBar()
                    mahasiswa.onSuccess(response.message ?: "", response.data)

                } else {
                    mahasiswa.hideProgressBar()
                    mahasiswa.onError(response.message ?: "")
                }
            }, { error ->
                mahasiswa.hideProgressBar()
                mahasiswa.onError(error.localizedMessage)
            })
    }

    fun hapusData(id: String){
        val hapus = ConfigNetwork.anggotaService().deleteData(id ?: "")
        hapus.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->
                mahasiswa.hapusSuccess(response.message ?: "")
            }, {error ->
                mahasiswa.onError(error.localizedMessage)
            })
    }
}