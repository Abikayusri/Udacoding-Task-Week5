package abika.sinau.mahasiswaappabika.ui.main

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.adapter.MahasiswaAdapter
import abika.sinau.mahasiswaappabika.helper.SessionManager
import abika.sinau.mahasiswaappabika.model.DataItemAnggota
import abika.sinau.mahasiswaappabika.ui.ProfileActivity
import abika.sinau.mahasiswaappabika.ui.login.LoginActivity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainView {

    lateinit var session: SessionManager
    private var presenter: MainPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        session = SessionManager(this)
        tvMainUser.text = session.nama ?: "Datanya"

        presenter = MainPresenter(this)
        presenter?.getMahasiswa()

        val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        title = "Home"


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.actionProfile -> {
                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.actionLogout -> {
                session.logout()

                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                true
            }
            else -> true
        }
    }

    override fun onSuccess(msg: String, mahasiswa: List<DataItemAnggota?>?) {
        val adapter = MahasiswaAdapter(mahasiswa)
        rvMain.adapter = adapter
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}