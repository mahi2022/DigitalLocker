package com.ampm9596.digitallocker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fManager=supportFragmentManager
        var tx=fManager.beginTransaction()
        tx.add(R.id.frag1,Login())
        tx.commit()
    }
}
