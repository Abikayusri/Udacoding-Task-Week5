package abika.sinau.mahasiswaappabika.ui.login

import abika.sinau.mahasiswaappabika.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Abika Chairul Yusri
 * on Wednesday, 17 June 2020
 * Bismillahirrahmanirrahim
 */
class LoginPresenter(val login: LoginView) {

    fun login(email: String, password: String) {

        if (email.isNotEmpty() && password.isNotEmpty()) {
            ConfigNetwork.userService().login(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if (response.isSuccess ?: true) {
                        login.loginSuccess(response.message ?: "", response.data)
                    } else {
                        login.errorLogin(response.message ?: "")
                    }

                }, { error ->
                    login.errorLogin(error.localizedMessage)
                })

        } else {
            login.errorLogin("Data tidak boleh kosong")
        }

    }
}