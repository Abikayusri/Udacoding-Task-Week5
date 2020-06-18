package abika.sinau.mahasiswaappabika.ui.register

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.model.ResponseUserRegister
import abika.sinau.mahasiswaappabika.ui.login.LoginActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_action.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterView {

    private var presenter: RegisterPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this)

        btnRegister.setOnClickListener {
            val nama = etRegisName.text.toString()
            val email = etRegisEmail.text.toString()
            val password = etRegisPassword.text.toString()
            val conPassword = etRegisConPassword.text.toString()

            validateData()

            presenter?.register(nama, email, password, conPassword)
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }

    fun validateData() {
        when {
            etRegisName.text.isEmpty() -> {
                etRegisName.error = "NIM tidak boleh kosong"
            }
            etRegisEmail.text.isEmpty() -> {
                etRegisEmail.error = "Nama tidak boleh kosong"
            }
            etRegisPassword.text.isEmpty() -> {
                etRegisPassword.error = "Password tidak boleh kosong"
            }
            etRegisConPassword.text.isEmpty() -> {
                etRegisConPassword.error = "Konfirmasi Password tidak boleh kosong"
            }
        }
    }

    override fun successRegister(response: ResponseUserRegister) {
        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
    }

    override fun errorRegister(msg: String) {
        showToast(msg)
    }

    override fun empty() {
        showToast("Data tidak boleh kosong")
    }

    override fun noMatch() {
        showToast("Password tidak cocok")
    }

    override fun startProgressBar() {
        pbRegis.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        pbRegis.visibility = View.GONE
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}