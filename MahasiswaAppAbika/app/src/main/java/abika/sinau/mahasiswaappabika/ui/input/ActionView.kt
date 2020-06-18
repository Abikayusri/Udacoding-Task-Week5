package abika.sinau.mahasiswaappabika.ui.input

import abika.sinau.mahasiswaappabika.model.ResponseAnggotaAction

/**
 * Created by Abika Chairul Yusri
 * on Thursday, 18 June 2020
 * Bismillahirrahmanirrahim
 */
interface ActionView {
    fun inputSuccess(response: ResponseAnggotaAction)
    fun inputError(msg: String)
    fun updateSuccess(response: ResponseAnggotaAction)
    fun updateError(msg: String)
    fun empty()
    fun startProgressBar()
    fun hideProgressBar()
}