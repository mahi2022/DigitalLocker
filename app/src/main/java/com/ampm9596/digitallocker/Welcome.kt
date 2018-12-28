package com.ampm9596.digitallocker

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.welcome.view.*

class Welcome : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var v = inflater.inflate(R.layout.welcome,container,false)


        var spf: SharedPreferences = activity!!.getSharedPreferences(
            "mahi", Context.MODE_PRIVATE)

        var uname_spf = spf.getString("uname","no value")

        v.welcome_msg.text = "Welcome to DigiLock :   $uname_spf"


        /*var uname_spf = spf.getString("uname","no value")

        v.welcome_msg.text = "Welcome :   $uname_spf"*/

        v.logout.setOnClickListener {
            var fManager = activity!!.supportFragmentManager
            var tx = fManager.beginTransaction()
            tx.replace(R.id.frag1,Login())
            tx.commit()

        }

        return v
    }

}