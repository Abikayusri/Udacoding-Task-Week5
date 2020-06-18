package abika.sinau.mahasiswaappabika.ui.register

import abika.sinau.mahasiswaappabika.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Abika Chairul Yusri
 * on Wednesday, 17 June 2020
 * Bismillahirrahmanirrahim
 */
class RegisterPresenter(val registerView: RegisterView) {

    fun register(nama: String, email: String, password: String, passConf: String) {

        registerView.startProgressBar()

        if (nama.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && passConf.isNotEmpty()) {
            registerView.hideProgressBar()
            when {
                password != passConf -> {
                    registerView.hideProgressBar()
                    registerView.noMatch()
                }

                password.length <= 5 -> {
                    registerView.hideProgressBar()
                    registerView.errorRegister("Password harus lebih dari 5 karakter")
                }

                else -> {
                    registerView.hideProgressBar()
                    ConfigNetwork.userService().register(nama, email, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ response ->
                            if (response.isSuccess ?: true) {
                                registerView.hideProgressBar()
                                registerView.successRegister(response)
                            } else {
                                registerView.hideProgressBar()
                                registerView.errorRegister(response.message ?: "")
                            }
                        }, { error ->
                            registerView.hideProgressBar()
                            registerView.errorRegister(error.localizedMessage)
                        })
                }
            }
        } else {
            registerView.hideProgressBar()
            registerView.empty()
        }
    }
}