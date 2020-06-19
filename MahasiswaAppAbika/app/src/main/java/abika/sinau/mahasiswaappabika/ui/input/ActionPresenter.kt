package abika.sinau.mahasiswaappabika.ui.input

import abika.sinau.mahasiswaappabika.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Abika Chairul Yusri
 * on Thursday, 18 June 2020
 * Bismillahirrahmanirrahim
 */
class ActionPresenter(val actionView: ActionView) {

    fun inputData(
        nim: String,
        nama: String,
        nohp: String,
        jurusan: String,
        semester: String,
        alamat: String
    ) {
        actionView.startProgressBar()

        if (nim.isNotEmpty() && nama.isNotEmpty() && nohp.isNotEmpty()
            && jurusan.isNotEmpty() && semester.isNotEmpty() && alamat.isNotEmpty()
        ) {
            when {
                nohp.length < 12 -> {
                    actionView.hideProgressBar()
                    actionView.inputError("Nomor HP kurang lengkap")
                }
                semester.toInt() > 14 -> {
                    actionView.hideProgressBar()
                    actionView.inputError("Semester tidak bisa lebih dari 14")
                }
                else -> {
                    actionView.hideProgressBar()
                    ConfigNetwork.anggotaService()
                        .insertData(nama, nim, nohp, jurusan, semester, alamat)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ response ->
                            if (response.isSuccess ?: true) {
                                actionView.hideProgressBar()
                                actionView.inputSuccess(response)
                            } else {
                                actionView.hideProgressBar()
                                actionView.inputError(response.message ?: "")
                            }
                        }, { error ->
                            actionView.hideProgressBar()
                            actionView.inputError(error.localizedMessage)
                        })
                }
            }
        } else {
            actionView.hideProgressBar()
            actionView.empty()
        }
    }

    fun updateData(
        id: String,
        nim: String,
        nama: String,
        nohp: String,
        jurusan: String,
        semester: String,
        alamat: String
    ) {
        actionView.startProgressBar()
        if (id.isNotEmpty() && nim.isNotEmpty() && nama.isNotEmpty() && nohp.isNotEmpty()
            && jurusan.isNotEmpty() && semester.isNotEmpty() && alamat.isNotEmpty()
        ) {
            when {
                nohp.length < 12 -> {
                    actionView.hideProgressBar()
                    actionView.inputError("Nomor HP kurang lengkap")
                }
                semester.toInt() > 14 -> {
                    actionView.hideProgressBar()
                    actionView.inputError("Semester tidak bisa lebih dari 14")
                }
                else -> {
                    actionView.hideProgressBar()
                    ConfigNetwork.anggotaService()
                        .updateData(id, nim, nama, nohp, jurusan, semester, alamat)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ response ->
                            if (response.isSuccess ?: true) {
                                actionView.hideProgressBar()
                                actionView.updateSuccess(response)
                            } else {
                                actionView.hideProgressBar()
                                actionView.inputError(response.message ?: "")
                            }
                        }, { error ->
                            actionView.hideProgressBar()
                            actionView.updateError(error.localizedMessage)
                        })
                }
            }
        } else {
            actionView.hideProgressBar()
            actionView.empty()
        }
    }
}