package abika.sinau.mahasiswaappabika.ui

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.helper.SessionManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initToolbar()

        val session = SessionManager(this)

        tvProfileNama.text = session.nama
        tvProfileEmail.text = session.email
    }

    private fun initToolbar() {
        tbProfile.setNavigationOnClickListener {
            onBackPressed()
        }
        tbProfile.title = "Pofile"
    }

    // gak ada suaranya mas?
}