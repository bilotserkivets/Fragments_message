package com.example.fragmentsmesssage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.fragmentsmesssage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binging: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)

        addFragment(R.id.placeHolder1, Fragment_1.newInstance())
        addFragment(R.id.placeHolder2, Fragment_2.newInstance())

        dataModel.messageAct.observe(this, {
            binging.textActivity.text = it
        })

    }

    private fun addFragment(idHolder: Int, f: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}