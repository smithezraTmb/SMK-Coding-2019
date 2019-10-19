package com.EzraSmithTambunan.smkcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_listmovie.*
import org.jetbrains.anko.support.v4.viewPager

class listmovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listmovie)

        page.adapter = TabLayoutAdapter(supportFragmentManager, this)

        tablayaout.setupWithViewPager(page)

    }
}
