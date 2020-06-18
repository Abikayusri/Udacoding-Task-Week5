package abika.sinau.mahasiswaappabika.ui.register

import abika.sinau.mahasiswaappabika.model.ResponseUserRegister

/**
 * Created by Abika Chairul Yusri
 * on Wednesday, 17 June 2020
 * Bismillahirrahmanirrahim
 */
interface RegisterView {

    fun successRegister(response: ResponseUserRegister)
    fun errorRegister(msg: String)
    fun empty()
    fun noMatch()
    fun startProgressBar()
    fun hideProgressBar()
}