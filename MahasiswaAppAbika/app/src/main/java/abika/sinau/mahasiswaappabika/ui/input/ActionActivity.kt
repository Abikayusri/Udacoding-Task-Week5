package abika.sinau.mahasiswaappabika.ui.input

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.model.DataItemAnggota
import abika.sinau.mahasiswaappabika.model.ResponseAnggotaAction
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_action.*

class ActionActivity : AppCompatActivity(), ActionView {

    var nim: String? = null
    var nama: String? = null
    var nohp: String? = null
    var jurusan: String? = null
    var semester: String? = null
    var alamat: String? = null
    private var presenter: ActionPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)

        presenter = ActionPresenter(this)

        initToolbar()

        val getData = intent.getParcelableExtra<DataItemAnggota>("Data")

        if (getData != null) {
            etNIM.setText(getData.mahasiswaNim)
            etNama.setText(getData.mahasiswaNama)
            etNoHp.setText(getData.mahasiswaNohp)
            etJurusan.setText(getData.mahasiswaJurusan)
            etSemester.setText(getData.mahasiswaSemester)
            etAlamat.setText(getData.mahasiswaAlamat)

            btnSave.text = "Update"
            btnSave.setBackgroundResource(R.drawable.bg_button_update)

            tbInput.title = "Update Data"
        }

        btnSave.setOnClickListener {
            nim = etNIM.text.toString()
            nama = etNama.text.toString()
            nohp = etNoHp.text.toString()
            jurusan = etJurusan.text.toString()
            semester = etSemester.text.toString()
            alamat = etAlamat.text.toString()

            when (btnSave.text) {
                "Update" -> {
                    Log.d("test", "0")
                    validateData()
                    presenter?.updateData(
                        getData?.idMahasiswa ?: "",
                        nim ?: "",
                        nama ?: "",
                        nohp ?: "",
                        jurusan ?: "",
                        semester ?: "",
                        alamat ?: ""
                    )
                }
                else -> {
                    Log.d("test", "1")
                    validateData()
                    presenter?.inputData(
                        nim ?: "",
                        nama ?: "",
                        nohp ?: "",
                        jurusan ?: "",
                        semester ?: "",
                        alamat ?: ""
                    )
                    Log.d("Data",nim ?: "")
                }
            }
        }

        btnBatal.setOnClickListener {
            finish()
        }
    }

    private fun initToolbar() {
        tbInput.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun inputSuccess(response: ResponseAnggotaAction) {
        finish()
    }

    override fun inputError(msg: String) {
        showToast(msg)
    }

    override fun updateSuccess(response: ResponseAnggotaAction) {
        finish()
    }

    override fun updateError(msg: String) {
        showToast(msg)
    }

    override fun empty() {
        showToast("Data tidak boleh kosong")
    }

    override fun startProgressBar() {
        pbAction.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        pbAction.visibility = View.GONE
    }

    fun showToast(msg: String) {
        Toast.makeText(this@ActionActivity, msg, Toast.LENGTH_SHORT).show()
    }

    fun validateData() {
        when {
            (etNIM.text.isEmpty() && etNama.text.isEmpty() && etNoHp.text.isEmpty()
                    && etJurusan.text.isEmpty() && etSemester.text.isEmpty() && etAlamat.text.isEmpty()) -> {
                etNIM.error = "NIM tidak boleh kosong"
                etNama.error = "Nama tidak boleh kosong"
                etNoHp.error = "Nomor HP tidak boleh kosong"
                etJurusan.error = "Jurusan tidak boleh kosong"
                etSemester.error = "Semester tidak boleh kosong"
                etAlamat.error = "Alamat tidak boleh kosong"
            }
            etNIM.text.isEmpty() -> {
                etNIM.error = "NIM tidak boleh kosong"
            }
            etNama.text.isEmpty() -> {
                etNama.error = "Nama tidak boleh kosong"
            }
            etNoHp.text.isEmpty() -> {
                etNoHp.error = "Nomor HP tidak boleh kosong"
            }
            etJurusan.text.isEmpty() -> {
                etJurusan.error = "Jurusan tidak boleh kosong"
            }
            etSemester.text.isEmpty() -> {
                etSemester.error = "Semester tidak boleh kosong"
            }
            etAlamat.text.isEmpty() -> {
                etAlamat.error = "Alamat tidak boleh kosong"
            }
        }
    }
}