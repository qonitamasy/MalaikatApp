package com.qonita.malaikatapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.qonita.malaikatapp.R

class DetailMalaikatActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DUTY = "extra_duty"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_malaikat)

        var actionBar = getSupportActionBar()
        actionBar?.setDisplayHomeAsUpEnabled(true)

        showMalaikatDetail()
    }

    private fun showMalaikatDetail() {
        //VARIABLE UNTUK MENAMPUNG ID LAYOUT
        val tvImageReceived: ImageView = findViewById(R.id.iv_item_photo)
        val tvNameReceived: TextView = findViewById(R.id.tv_item_name)
        val tvDutyReceived: TextView = findViewById(R.id.tv_item_duty)
        val tvDetailReceived: TextView = findViewById(R.id.tv_item_detail)

        //VARIABLE UNTUK INTENT
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val name = intent.getStringExtra(EXTRA_NAME)
        val duty = intent.getStringExtra(EXTRA_DUTY)
        val detail = intent.getStringExtra(EXTRA_DETAIL)

        tvImageReceived.setImageResource(photo)
        tvNameReceived.setText("$name")
        tvDutyReceived.setText("$duty")
        tvDetailReceived.setText("$detail")
    }

    override fun onSupportNavigateUp(): Boolean{
        onBackPressed()
        return true
    }
}