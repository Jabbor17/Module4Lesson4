package com.example.module4lesson4.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module4lesson4.R
import kotlinx.android.synthetic.main.activity_main.*
import models.Member
import models.User

class MainActivity : AppCompatActivity() {

    private val LAUNCH_DETAIL = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        click_me.setOnClickListener {
            openSecondActivity(User("Muhammadrizo", 18))
        }
    }

    private fun openSecondActivity(user: User) {
        startActivityForResult(Intent(this, SecondActivity::class.java).apply {
            putExtra("user", user)
        },LAUNCH_DETAIL)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LAUNCH_DETAIL){
            if (resultCode == Activity.RESULT_OK){
                tv_result.text = data?.getParcelableExtra<Member>("member").toString()
            }
        }
    }
}

