package abika.sinau.mahasiswaappabika.ui.login

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.helper.SessionManager
import abika.sinau.mahasiswaappabika.model.DataItemUser
import abika.sinau.mahasiswaappabika.ui.main.MainActivity
import abika.sinau.mahasiswaappabika.ui.register.RegisterActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private var presenter: LoginPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)

        btnLogin.setOnClickListener {

            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            presenter?.login(email, password)
        }

        tvDaftar.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }

    override fun loginSuccess(msg: String, user: List<DataItemUser?>?) {
        val session = SessionManager(this)
        session.email = user?.get(0)?.userEmail
        session.nama = user?.get(0)?.userNama
        session.isLogin = true
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finishAffinity()
    }

    override fun errorLogin(msg: String) {
        Toast.makeText(this@LoginActivity, msg, Toast.LENGTH_SHORT).show()
    }
}