package id.my.labsi.myapplocal

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditorActivity : AppCompatActivity() {

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        val edtFullName: EditText = findViewById(R.id.edt_fullname)
        val edtAge: EditText = findViewById(R.id.edt_age)
        val btnSave: Button = findViewById(R.id.btn_save)

        val sharedPref = applicationContext?.getSharedPreferences("my-app", Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()

        // simpan data
        btnSave.setOnClickListener {
            if (edtFullName.length() > 0 && edtAge.length() > 0){
                editor?.putString("full_name", edtFullName.text.toString())
                editor?.putInt("age", edtAge.text.toString().toInt())
                editor?.apply()

                finish()
            } else {
                Toast.makeText(applicationContext, "Silahkan isi semua data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}