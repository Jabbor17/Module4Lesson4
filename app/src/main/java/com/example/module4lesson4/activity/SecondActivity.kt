package com.example.module4lesson4.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.module4lesson4.R
import kotlinx.android.synthetic.main.activity_second.*
import models.Member
import models.User

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initViews()
    }

    private fun initViews() {
        name_tv.text = intent.getParcelableExtra<User>("user").toString()
        age_tv.text = intent.getParcelableExtra<User>("user").toString()

        reply.setOnClickListener {
            backToFinish(Member("Member",222))
        }
    }

    private fun backToFinish(member: Member) {
        setResult(Activity.RESULT_OK, Intent(this, MainActivity::class.java).apply {
            putExtra("member", member)
        })
        finish()
    }
}

