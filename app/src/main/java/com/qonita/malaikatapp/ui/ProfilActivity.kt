package com.qonita.malaikatapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.qonita.malaikatapp.R

class ProfilActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BORN = "extra_born"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PROFIL = "extra_profil"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val tvNameReceived: TextView = findViewById(R.id.tv_text_name)
        val tvBornReceived: TextView = findViewById(R.id.tv_text_born)
        val tvEmailReceived: TextView = findViewById(R.id.tv_text_email)
        val ivProfilReceived: ImageView = findViewById(R.id.iv_profil)


        val name = intent.getStringExtra(EXTRA_NAME)
        val born = intent.getStringExtra(EXTRA_BORN)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val profil = intent.getIntExtra(EXTRA_PROFIL, 0)

        tvNameReceived.setText("$name")
        tvBornReceived.setText("$born")
        tvEmailReceived.setText("$email")
        ivProfilReceived.setImageResource(profil)

    }
}