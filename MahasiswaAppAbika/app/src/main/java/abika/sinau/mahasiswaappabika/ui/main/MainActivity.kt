package abika.sinau.mahasiswaappabika.ui.main

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.adapter.MahasiswaAdapter
import abika.sinau.mahasiswaappabika.helper.SessionManager
import abika.sinau.mahasiswaappabika.model.DataItemAnggota
import abika.sinau.mahasiswaappabika.network.ConfigNetwork
import abika.sinau.mahasiswaappabika.ui.ProfileActivity
import abika.sinau.mahasiswaappabika.ui.input.ActionActivity
import abika.sinau.mahasiswaappabika.ui.login.LoginActivity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
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

        val toolbar: Toolbar = findViewById<View>(R.id.tbMain) as Toolbar
        setSupportActionBar(toolbar)
        title = "Home"

        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, ActionActivity::class.java))
        }

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
        val adapter = MahasiswaAdapter(mahasiswa, object : MahasiswaAdapter.OnClickListener{
            override fun hapus(item: DataItemAnggota?) {
                AlertDialog.Builder(this@MainActivity).apply {
                    setTitle("Hapus Data")
                    setMessage("Yakin mau hapus data ?")
                    setPositiveButton("Hapus") { dialog, which ->
                        hapusData(item?.idMahasiswa)
                        dialog.dismiss()
                    }
                    setNegativeButton("Batal") { dialog, which ->
                        dialog.dismiss()
                    }
                }.show()
            }

        })
        rvMain.adapter = adapter
    }

    private fun hapusData(id: String?) {
        presenter?.hapusData(id ?: "")
    }


    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun startProgressBar() {
        pbMain.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        pbMain.visibility = View.GONE
    }

    override fun hapusSuccess(msg: String) {
        Toast.makeText(this@MainActivity, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()
        presenter?.getMahasiswa()
    }

    override fun onResume() {
        super.onResume()
        presenter?.getMahasiswa()
    }
}