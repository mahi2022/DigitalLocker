package com.ampm9596.digitallocker

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.login.view.*
import kotlinx.android.synthetic.main.register.*
import kotlinx.android.synthetic.main.register.view.*
import kotlinx.android.synthetic.main.welcome.view.*

class RegisterFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var v=inflater.inflate(R.layout.register, container,false)

        v.submit.setOnClickListener {
            if (validastions(v)) {
                var spf = activity!!.getSharedPreferences("mahi", Context.MODE_PRIVATE)
                var spe: SharedPreferences.Editor = spf.edit()
                spe.putString("uname", v.user.text.toString())
                spe.putString("email", v.email.text.toString())
                spe.putString("mobile", v.mobile.text.toString())
                spe.putString("pass", password.text.toString())
                spe.commit()

                var fManager = activity!!.supportFragmentManager
                var tx = fManager.beginTransaction()
                tx.replace(R.id.frag1, Login())
                tx.commit()

                Toast.makeText(activity, "Please Login", Toast.LENGTH_LONG).show()
            }
        }

        v.back.setOnClickListener {
            var fManager = activity!!.supportFragmentManager
            var tx = fManager.beginTransaction()
            tx.replace(R.id.frag1,Login())
            tx.commit()

        }
        return v
    }

    fun validastions(v:View):Boolean {
        var msg = ""

       if (v.user.text.length==0) {
            msg = "plz enter user name"
        }
        if (v.email.text.length == 0) {
            msg = msg + "\n plz enter valid email"
        }
        if (v.mobile.text.length != 10) {
            msg = msg + "\n enter valid moble number"
        }
        if (v.password.text.length==0){
            msg=msg+"\n enter password"
        }

        if (msg.equals("")){
            return true
        }else{
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
            return false
        }
    }
}// reg