package com.qonita.malaikatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qonita.malaikatapp.data.MalaikatData
import com.qonita.malaikatapp.data.MalaikatDataObject
import com.qonita.malaikatapp.ui.DetailMalaikatActivity
import com.qonita.malaikatapp.ui.ListMalaikatAdapter
import com.qonita.malaikatapp.ui.ProfilActivity

class MainActivity : AppCompatActivity() {
    private lateinit var rvMalaikat: RecyclerView
    private var list: ArrayList<MalaikatData> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMalaikat = findViewById(R.id.rv_malaikat)
        rvMalaikat.setHasFixedSize(true)
        list.addAll(MalaikatDataObject.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMalaikat.layoutManager = LinearLayoutManager(this)
        val listMalaikatAdapter = ListMalaikatAdapter(list)
        rvMalaikat.adapter = listMalaikatAdapter

        listMalaikatAdapter.setOnItemClickCallback(object :
            ListMalaikatAdapter.OnItemCLickCallback {
            override fun onItemClickedData(data: MalaikatData) {
                showSelectedMalaikat(data)
            }


        })

    }

    private fun showSelectedMalaikat(data: MalaikatData) {
        val detailMalaikatActivity =
            Intent(this@MainActivity, DetailMalaikatActivity::class.java).apply {
                putExtra(DetailMalaikatActivity.EXTRA_PHOTO, data.photo)
                putExtra(DetailMalaikatActivity.EXTRA_NAME, data.name)
                putExtra(DetailMalaikatActivity.EXTRA_DUTY, data.duty)
                putExtra(DetailMalaikatActivity.EXTRA_DETAIL, data.detail)
            }
        startActivity(detailMalaikatActivity)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_profil -> {
                val moveIntent = Intent(this@MainActivity, ProfilActivity::class.java)
                moveIntent.putExtra(ProfilActivity.EXTRA_PROFIL, R.drawable.profil)
                moveIntent.putExtra(ProfilActivity.EXTRA_NAME,"Qonita Masyitoh")
                moveIntent.putExtra(ProfilActivity.EXTRA_EMAIL,"qonitamasitoh212@gmail.com")
                moveIntent.putExtra(ProfilActivity.EXTRA_BORN, "2 Desember 2005")
                startActivity(moveIntent)
            }
        }
    }
}
