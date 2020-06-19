package abika.sinau.mahasiswaappabika.ui.main

import abika.sinau.mahasiswaappabika.model.DataItemAnggota

/**
 * Created by Abika Chairul Yusri
 * on Thursday, 18 June 2020
 * Bismillahirrahmanirrahim
 */
interface MainView {
    fun onSuccess(msg: String, mahasiswa: List<DataItemAnggota?>?)
    fun onError(msg: String)
    fun startProgressBar()
    fun hideProgressBar()

    fun hapusSuccess(msg: String)

//    fun detail(item: DataItemAnggota?)
//    fun hapus(item: DataItemAnggota?)
}