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

        //actionbar
//        val actionbar = supportActionBar
        //set actionbar title
//        actionbar!!.title = "Profile"
        //set back button
//        actionbar.setDisplayHomeAsUpEnabled(true)
//        actionbar.setDisplayShowHomeEnabled(true)

        val session = SessionManager(this)

        tvProfileNama.text = session.nama
        tvProfileEmail.text = session.email
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}