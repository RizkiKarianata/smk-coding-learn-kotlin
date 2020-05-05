package com.example.challenge1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var namaInput : String = ""
    private var emailInput : String = ""
    private var telpInput : String = ""
    private var alamatInput : String = ""
    private var genderInput : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDataSpinnerGender()
        validasiInput()
        btnSave.setOnClickListener { validasiInput() }
    }

    private fun setDataSpinnerGender(){
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.jenis_kelamin, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_ite
                m)
        spinnerGender.adapter = adapter
    }

    private fun validasiInput(){
        dalam variabel yang telah dibuat
        namaInput = edtName.text.toString()
        emailInput = edtEmail.text.toString()
        telpInput = edtTelp.text.toString()
        alamatInput = edtAddress.text.toString()
        genderInput = spinnerGender.selectedItem.toString()
        when{
            tampilkan error
                    namaInput.isEmpty() -> edtName.error = "Nama tidak boleh kosong"
            genderInput.equals("Pilih Jenis Kelamin", ignoreCase = true) ->
                tampilToast("Jenis Kelamin harus dipilih")
            emailInput.isEmpty() -> edtEmail.error = "Email tidak boleh
            kosong"
                telpInput.isEmpty() -> edtTelp.error = "Telp tidak boleh kosong"
            alamatInput.isEmpty() -> edtAddress.error = "Alamat tidak boleh
            kosong"
            else -> {
                goToProfilActivity
                tampilToast("Navigasi ke halaman profil")
                goToProfilActivity()
            }
        }
    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun goToProfilActivity() {
        val intent = Intent(this, ProfilActivity::class.java)
        val bundle = Bundle()
        bundle.putString("nama", namaInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
