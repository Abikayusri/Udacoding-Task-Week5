package abika.sinau.mahasiswaappabika.ui.login

import abika.sinau.mahasiswaappabika.model.DataItemUser

/**
 * Created by Abika Chairul Yusri
 * on Wednesday, 17 June 2020
 * Bismillahirrahmanirrahim
 */
interface LoginView {
    fun loginSuccess(msg: String, user: List<DataItemUser?>?)
    fun errorLogin(msg: String)
    fun startProgressBar()
    fun hideProgressBar()
}